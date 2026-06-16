package ai.platon.pulsar.browser.driver.chrome.impl

import ai.platon.pulsar.browser.driver.chrome.util.ChromeRPCException
import ai.platon.pulsar.common.getLogger
import ai.platon.pulsar.common.getTracerOrNull
import ai.platon.pulsar.common.stringify
import kotlinx.coroutines.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*
import org.apache.commons.lang3.StringUtils
import java.io.IOException
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentSkipListSet
import java.util.concurrent.atomic.AtomicBoolean
import java.util.function.Consumer

/**
 * Coroutine-friendly invocation result wrapper to avoid blocking the calling thread.
 */
data class RpcResult(
    val isSuccess: Boolean,
    val result: JsonElement?,
    val message: String? = null
)

/**
 * Coroutine-based future that completes when a response with the matching id arrives.
 */
class InvocationFuture(val returnProperty: String? = null) {
    val deferred: CompletableDeferred<RpcResult> = CompletableDeferred()
}

/** Error object returned from dev tools. */
@Serializable
internal class ErrorObject {
    var code: Long = 0
    var message: String = ""
    var data: String? = null
}

class EventDispatcher : Consumer<String>, AutoCloseable {

    private val codec = CdpMessageCodec()

    private val logger = getLogger(this)

    private val tracer = getTracerOrNull(this)

    private val closed = AtomicBoolean()
    private val invocationFutures: MutableMap<Long, InvocationFuture> = ConcurrentHashMap()
    private val eventListeners: ConcurrentHashMap<String, ConcurrentSkipListSet<DevToolsEventListener>> =
        ConcurrentHashMap()

    private val eventDispatcherScope =
        CoroutineScope(SupervisorJob() + Dispatchers.Default + CoroutineName("EventDispatcher"))

    val isActive get() = !closed.get()

    fun patchMessageForProtocolChange(message: String, force: Boolean = false): String {
        return codec.patchMessageForProtocolChange(message, force)
    }

    /**
     * Serializes a message into a CDP wire-format JSON string.
     * Delegates to [CdpMessageCodec].
     */
    fun serialize(message: Any): String = codec.serialize(message)

    /**
     * Builds the CDP wire-format JSON message.
     * Delegates to [CdpMessageCodec].
     */
    fun serialize(id: Long, method: String, params: Map<String, Any>?, sessionId: String?): String =
        codec.serialize(id, method, params, sessionId)

    /**
     * Deserializes a [JsonElement] into a parameterized type.
     * Delegates to [CdpMessageCodec].
     */
    @Throws(IOException::class)
    fun <T> deserialize(classParameters: Array<Class<*>>, parameterizedClazz: Class<T>, jsonElement: JsonElement): T =
        codec.deserialize(classParameters, parameterizedClazz, jsonElement)

    /**
     * Deserializes a [JsonElement] into a plain (non-generic) class.
     * Delegates to [CdpMessageCodec].
     */
    @Throws(IOException::class, ChromeRPCException::class)
    fun <T : Any> deserialize(clazz: Class<*>, jsonElement: JsonElement?): T =
        codec.deserialize(clazz, jsonElement)

    /** Convert a params map to a [JsonElement]. Delegates to [CdpMessageCodec]. */
    fun paramsMapToJsonElement(params: Map<String, Any>): JsonElement =
        codec.paramsMapToJsonElement(params)

    /** Convert an arbitrary value to a [JsonElement]. Delegates to [CdpMessageCodec]. */
    fun anyToJsonElement(value: Any?): JsonElement =
        codec.anyToJsonElement(value)

    // ---------------------------------------------------------------------------
    // Future / subscription management
    // ---------------------------------------------------------------------------

    fun hasFutures() = invocationFutures.isNotEmpty()

    fun subscribe(id: Long, returnProperty: String?): InvocationFuture {
        return invocationFutures.computeIfAbsent(id) { InvocationFuture(returnProperty) }
    }

    fun unsubscribe(id: Long) {
        invocationFutures.remove(id)
    }

    fun unsubscribeAll() {
        val ids = invocationFutures.keys.toList()
        ids.forEach { id ->
            invocationFutures.remove(id)?.deferred?.complete(RpcResult(false, null))
        }
    }

    fun registerListener(key: String, listener: DevToolsEventListener) {
        eventListeners.computeIfAbsent(key) { ConcurrentSkipListSet<DevToolsEventListener>() }.add(listener)
    }

    fun unregisterListener(key: String, listener: DevToolsEventListener) {
        eventListeners[key]?.removeIf { listener.handler == it.handler }
    }

    fun removeAllListeners() {
        eventListeners.clear()
    }

    // ---------------------------------------------------------------------------
    // Incoming message dispatch
    // ---------------------------------------------------------------------------

    @Throws(ChromeRPCException::class, IOException::class)
    override fun accept(message: String) {
        tracer?.trace("◀ Accept {}", StringUtils.abbreviateMiddle(message, "...", 20000))

        try {
            val jsonElement = CdpMessageCodec.JSON.parseToJsonElement(message)
            val jsonObject = jsonElement.jsonObject
            val idElement = jsonObject[CdpMessageCodec.ID_PROPERTY]
            if (idElement != null) {
                val id = idElement.jsonPrimitive.long
                val future = invocationFutures.remove(id)

                if (future != null) {
                    var resultElement = jsonObject[CdpMessageCodec.RESULT_PROPERTY]
                    val errorElement = jsonObject[CdpMessageCodec.ERROR_PROPERTY]
                    if (errorElement != null) {
                        logger.debug("Error node: {}", StringUtils.abbreviateMiddle(message, "...", 20000))
                        future.deferred.complete(RpcResult(false, errorElement, message))
                    } else {
                        if (future.returnProperty != null) {
                            resultElement = resultElement?.let { it.jsonObject[future.returnProperty] }
                        }

                        future.deferred.complete(RpcResult(true, resultElement, message))
                    }
                } else {
                    logger.warn("Received response with unknown invocation #{} - {}", id, jsonElement.toString())
                }
            } else {
                val methodElement = jsonObject[CdpMessageCodec.METHOD_PROPERTY]
                val paramsElement = jsonObject[CdpMessageCodec.PARAMS_PROPERTY]
                if (methodElement != null) {
                    handleEventAsync(methodElement.jsonPrimitive.content, paramsElement)
                }
            }
        } catch (e: Exception) {
            val msg = StringUtils.abbreviateMiddle(message, "...", 500)
            logger.error("Failed to parse message | {} | {}", msg, e.stringify())
        }
    }

    /**
     * Closes the dispatcher. All event listeners will be removed and all waiting futures are signaled with failed.
     */
    override fun close() {
        if (closed.compareAndSet(false, true)) {
            unsubscribeAll()
            removeAllListeners()
            eventDispatcherScope.cancel()
        }
    }

    // ---------------------------------------------------------------------------
    // Event handling
    // ---------------------------------------------------------------------------

    private fun handleEventAsync(name: String, params: JsonElement?) {
        val listeners = eventListeners[name] ?: return

        // make a copy
        val unmodifiedListeners = mutableSetOf<DevToolsEventListener>()
        synchronized(listeners) { listeners.toCollection(unmodifiedListeners) }
        if (unmodifiedListeners.isEmpty()) {
            return
        }

        // Handle event in a separate coroutine
        eventDispatcherScope.launch {
            handleEvent0(params, unmodifiedListeners)
        }
    }

    /**
     * Handles the event by deserializing the params and calling the event handler.
     *
     * Do not throw any exception, all exceptions are caught and logged.
     */
    private suspend fun handleEvent0(params: JsonElement?, unmodifiedListeners: Iterable<DevToolsEventListener>) {
        try {
            handleEvent1(params, unmodifiedListeners)
        } catch (e: kotlinx.serialization.SerializationException) {
            logger.warn("Mismatched input, Chrome might have upgraded the protocol | {}", e.message)
        } catch (t: Throwable) {
            logger.warn("Failed to handle event", t)
        }
    }

    @Throws(ChromeRPCException::class, IOException::class)
    private suspend fun handleEvent1(params: JsonElement?, unmodifiedListeners: Iterable<DevToolsEventListener>) {
        var event: Any? = null
        for (listener in unmodifiedListeners) {
            if (event == null && params != null) {
                event = deserialize(listener.paramType, params)
            }

            if (event == null) continue

            try {
                listener.handler.onEvent(event)
            } catch (e: Exception) {
                logger.warn(
                    "Failed to handle event, rethrow ChromeRPCException. Enable debug logging to see the stack trace | {}",
                    e.message
                )
                logger.debug("Failed to handle event", e)
                throw ChromeRPCException("Failed to handle event | ${listener.key}, ${listener.paramType}", e)
            }
        }
    }
}
