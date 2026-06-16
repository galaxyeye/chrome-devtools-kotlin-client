@file:OptIn(InternalSerializationApi::class)

package ai.platon.browser4.chrome.handler.transport

import ai.platon.browser4.chrome.util.ChromeRPCException
import ai.platon.pulsar.common.getLogger
import ai.platon.pulsar.common.getTracerOrNull
import ai.platon.pulsar.common.stringify
import kotlinx.coroutines.*
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.json.*
import kotlinx.serialization.serializer
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
@kotlinx.serialization.Serializable
internal class ErrorObject {
    var code: Long = 0
    var message: String = ""
    var data: String? = null
}

class EventDispatcher : Consumer<String>, AutoCloseable {

    companion object {
        const val ID_PROPERTY = "id"
        const val ERROR_PROPERTY = "error"
        const val RESULT_PROPERTY = "result"
        const val METHOD_PROPERTY = "method"
        const val PARAMS_PROPERTY = "params"

        /** Shared JSON instance configured for CDP protocol messages. */
        val JSON = Json {
            ignoreUnknownKeys = true
            isLenient = true
            coerceInputValues = true
            encodeDefaults = true
        }
    }

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
        // Patch protocol changes if needed, e.g., some events might change their params structure across Chrome versions
        var patched = message
        if (force || patched.contains("clientSecurityState")) {
            patched = patched.replace("clientSecurityState", "clientSecurityState-Deleted")
        }
        return patched
    }

    fun serialize(message: Any): String {
        return when (message) {
            is ai.platon.pulsar.browser.impl.MethodInvocation -> serialize(message.id, message.method, message.params, null)
            else -> {
                @Suppress("UNCHECKED_CAST")
                val serializer = message::class.serializer() as KSerializer<Any>
                JSON.encodeToString(serializer, message)
            }
        }
    }

    fun serialize(id: Long, method: String, params: Map<String, Any>?, sessionId: String?): String {
        val jsonObject = buildJsonObject {
            put(ID_PROPERTY, JsonPrimitive(id))
            put(METHOD_PROPERTY, JsonPrimitive(method))
            if (params != null) {
                put(PARAMS_PROPERTY, paramsMapToJsonElement(params))
            }
            if (sessionId != null) {
                put("sessionId", JsonPrimitive(sessionId))
            }
        }
        return JSON.encodeToString(jsonObject)
    }

    @Throws(IOException::class)
    fun <T> deserialize(classParameters: Array<Class<*>>, parameterizedClazz: Class<T>, jsonElement: JsonElement): T {
        val serializer = buildParameterizedSerializer(classParameters, parameterizedClazz)
        try {
            @Suppress("UNCHECKED_CAST")
            return JSON.decodeFromJsonElement(serializer as KSerializer<T>, jsonElement)
        } catch (e: Exception) {
            logger.warn("Failed to deserialize class ${parameterizedClazz.name}\n", e)
            throw e
        }
    }

    /**
     * A typical Server Side Event:
     * ```json
     * {"method":"Page.frameStartedLoading","params":{"frameId":"53F48CA08C50A3A72887CB9F15B293D5"}}
     * ```
     */
    @Throws(IOException::class, ChromeRPCException::class)
    @Suppress("UNCHECKED_CAST")
    fun <T : Any> deserialize(clazz: Class<*>, jsonElement: JsonElement?): T {
        if (jsonElement == null) {
            throw ChromeRPCException("Failed converting null response to clazz ${clazz.name}")
        }

        try {
            val serializer = clazz.kotlin.serializer() as KSerializer<T>
            return JSON.decodeFromJsonElement(serializer, jsonElement)
        } catch (e: SerializationException) {
            val message = """
                Failed converting response to clazz ${clazz.name}
                $jsonElement
                """.trimIndent()
            logger.warn(message, e)
            throw IOException("Failed converting response to clazz ${clazz.name}", e)
        }
    }

    // ---------------------------------------------------------------------------
    // Internal helpers
    // ---------------------------------------------------------------------------

    /**
     * Converts a CDP params map into a [JsonObject], handling enums and nested
     * [@Serializable][kotlinx.serialization.Serializable] objects through kotlinx.serialization.
     */
    @Suppress("UNCHECKED_CAST")
    fun paramsMapToJsonElement(params: Map<String, Any>): JsonElement {
        return buildJsonObject {
            params.forEach { (key, value) ->
                put(key, anyToJsonElement(value))
            }
        }
    }

    /**
     * Converts an arbitrary value to a [JsonElement], using kotlinx.serialization
     * for [@Serializable][kotlinx.serialization.Serializable] objects and standard primitives for everything else.
     */
    @Suppress("UNCHECKED_CAST")
    fun anyToJsonElement(value: Any?): JsonElement {
        return when (value) {
            null -> JsonNull
            is JsonElement -> value
            is String -> JsonPrimitive(value)
            is Number -> JsonPrimitive(value)
            is Boolean -> JsonPrimitive(value)
            is Enum<*> -> {
                val serializer = (value as Enum<*>).declaringJavaClass.kotlin.serializer() as KSerializer<Any>
                JSON.encodeToJsonElement(serializer, value)
            }
            is Map<*, *> -> buildJsonObject {
                value.forEach { (k, v) ->
                    put(k.toString(), anyToJsonElement(v))
                }
            }
            is List<*> -> buildJsonArray {
                value.forEach { add(anyToJsonElement(it)) }
            }
            else -> {
                // @Serializable data classes (e.g. Viewport, LoadNetworkResourceOptions, etc.)
                val serializer = value::class.serializer() as KSerializer<Any>
                JSON.encodeToJsonElement(serializer, value)
            }
        }
    }

    /**
     * Builds a [KSerializer] for a parameterized type from runtime [Class] objects.
     */
    @OptIn(InternalSerializationApi::class)
    @Suppress("UNCHECKED_CAST")
    private fun buildParameterizedSerializer(
        classParameters: Array<Class<*>>,
        parameterizedClazz: Class<*>
    ): KSerializer<*> {
        val typeParamCount = parameterizedClazz.typeParameters.size

        return when {
            classParameters.isEmpty() -> parameterizedClazz.kotlin.serializer() as KSerializer<Any>

            typeParamCount <= 1 -> {
                var inner: KSerializer<*> = classParameters.last().kotlin.serializer() as KSerializer<Any>
                for (i in classParameters.size - 2 downTo 0) {
                    inner = ListSerializer(inner as KSerializer<Any>)
                }
                ListSerializer(inner as KSerializer<Any>)
            }

            typeParamCount == 2 -> {
                if (classParameters.size == 2) {
                    val keySer = classParameters[0].kotlin.serializer() as KSerializer<Any>
                    val valueSer = classParameters[1].kotlin.serializer() as KSerializer<Any>
                    MapSerializer(keySer, valueSer)
                } else {
                    var valueSer: KSerializer<*> = classParameters.last().kotlin.serializer() as KSerializer<Any>
                    for (i in classParameters.size - 2 downTo 1) {
                        valueSer = ListSerializer(valueSer as KSerializer<Any>)
                    }
                    val keySer = classParameters[0].kotlin.serializer() as KSerializer<Any>
                    MapSerializer(keySer, valueSer as KSerializer<Any>)
                }
            }

            else -> {
                val serializers = classParameters.map { it.kotlin.serializer() as KSerializer<Any> }
                serializers.first()
            }
        }
    }

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
        // Complete any pending futures with a failed result to unblock waiters
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
            val jsonElement = JSON.parseToJsonElement(message)
            val jsonObject = jsonElement.jsonObject
            val idElement = jsonObject[ID_PROPERTY]
            if (idElement != null) {
                val id = idElement.jsonPrimitive.long
                val future = invocationFutures.remove(id)

                if (future != null) {
                    var resultElement = jsonObject[RESULT_PROPERTY]
                    val errorElement = jsonObject[ERROR_PROPERTY]
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
                val methodElement = jsonObject[METHOD_PROPERTY]
                val paramsElement = jsonObject[PARAMS_PROPERTY]
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
     *
     * A typical Server Side Event:
     * ```json
     * {"method":"Page.frameStartedLoading","params":{"frameId":"53F48CA08C50A3A72887CB9F15B293D5"}}
     * ```
     *
     * @param params the params node
     * @param unmodifiedListeners the listeners
     */
    private suspend fun handleEvent0(params: JsonElement?, unmodifiedListeners: Iterable<DevToolsEventListener>) {
        try {
            handleEvent1(params, unmodifiedListeners)
        } catch (e: SerializationException) {
            logger.warn("Mismatched input, Chrome might have upgraded the protocol | {}", e.message)
        } catch (t: Throwable) {
            logger.warn("Failed to handle event", t)
        }
    }

    /**
     * A typical Server Side Event:
     * ```json
     * {"method":"Page.frameStartedLoading","params":{"frameId":"53F48CA08C50A3A72887CB9F15B293D5"}}
     * ```
     */
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
                // Let the exception throw again, they might be caught by RobustRPC, or somewhere else
                throw ChromeRPCException("Failed to handle event | ${listener.key}, ${listener.paramType}", e)
            }
        }
    }
}
