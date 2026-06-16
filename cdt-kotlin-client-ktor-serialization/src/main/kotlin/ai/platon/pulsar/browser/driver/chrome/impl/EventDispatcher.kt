package ai.platon.pulsar.browser.driver.chrome.impl

import ai.platon.pulsar.browser.driver.chrome.MethodInvocation
import ai.platon.pulsar.browser.driver.chrome.util.ChromeRPCException
import ai.platon.pulsar.common.getLogger
import ai.platon.pulsar.common.getTracerOrNull
import ai.platon.pulsar.common.stringify
import kotlinx.coroutines.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.*
import org.apache.commons.lang3.StringUtils
import java.io.IOException
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentSkipListSet
import java.util.concurrent.atomic.AtomicBoolean
import java.util.function.Consumer
import kotlin.reflect.full.companionObjectInstance

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
    @SerialName("code")
    var code: Long = 0
    @SerialName("message")
    var message: String = ""
    @SerialName("data")
    var data: String? = null
}

/**
 * Event dispatcher that serializes/deserializes CDP messages using kotlinx.serialization.
 *
 * Replaces the Jackson-based EventDispatcher from cdt-kotlin-client-ktor.
 */
class EventDispatcher : Consumer<String>, AutoCloseable {
    companion object {
        const val ID_PROPERTY = "id"
        const val ERROR_PROPERTY = "error"
        const val RESULT_PROPERTY = "result"
        const val METHOD_PROPERTY = "method"
        const val PARAMS_PROPERTY = "params"

        /** Shared Json instance configured for CDP protocol messages. */
        val JSON: Json = Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
            encodeDefaults = true
            isLenient = true
        }

        /** Cached serializers for generic types to avoid repeated construction. */
        private val serializerCache = ConcurrentHashMap<String, KSerializer<*>>()

        /** Build a ListSerializer for the given element serializer. */
        @Suppress("UNCHECKED_CAST")
        fun listSerializer(elementSerializer: KSerializer<*>): KSerializer<List<Any?>> {
            return ListSerializer(elementSerializer as KSerializer<Any?>) as KSerializer<List<Any?>>
        }

        /** Build a MapSerializer with String keys and the given value serializer. */
        @Suppress("UNCHECKED_CAST")
        fun mapSerializer(valueSerializer: KSerializer<*>): KSerializer<Map<String, Any?>> {
            return MapSerializer(String.serializer(), valueSerializer as KSerializer<Any?>) as KSerializer<Map<String, Any?>>
        }

        /**
         * Get or create a serializer for a class at runtime.
         *
         * Relies on the kotlinx.serialization compiler plugin which generates a
         * `.serializer()` companion method on every @Serializable class.
         */
        @Suppress("UNCHECKED_CAST")
        fun <T> serializerFor(clazz: Class<T>): KSerializer<T> {
            val key = clazz.name
            return serializerCache.computeIfAbsent(key) {
                val kClass = clazz.kotlin
                // Invoke the generated companion object's serializer() method
                val companion = kClass.companionObjectInstance
                if (companion != null) {
                    val method = companion::class.members.firstOrNull { m ->
                        m.name == "serializer" && m.parameters.size == 1
                    }
                    if (method != null) {
                        method.call(companion) as KSerializer<*>
                    } else {
                        kClass.serializer() as KSerializer<*>
                    }
                } else {
                    kClass.serializer() as KSerializer<*>
                }
            } as KSerializer<T>
        }

        /**
         * Convert an arbitrary runtime value to a [JsonElement].
         *
         * Handles primitives, maps, lists, and @Serializable objects.  Falls back
         * to [toString] for types that are not natively supported.
         */
        @Suppress("UNCHECKED_CAST")
        fun toJsonElement(value: Any?): JsonElement {
            return when (value) {
                null -> JsonNull
                is JsonElement -> value
                is String -> JsonPrimitive(value)
                is Number -> JsonPrimitive(value)
                is Boolean -> JsonPrimitive(value)
                is Enum<*> -> JsonPrimitive(value.name)
                is Map<*, *> -> {
                    buildJsonObject {
                        @Suppress("UNCHECKED_CAST")
                        (value as Map<String, Any?>).forEach { (k, v) ->
                            put(k, toJsonElement(v))
                        }
                    }
                }
                is Iterable<*> -> {
                    buildJsonArray {
                        value.forEach { add(toJsonElement(it)) }
                    }
                }
                is Array<*> -> {
                    buildJsonArray {
                        value.forEach { add(toJsonElement(it)) }
                    }
                }
                else -> {
                    // Try to use the generated serializer for @Serializable types
                    try {
                        val serializer = serializerFor(value.javaClass) as KSerializer<Any>
                        JSON.encodeToJsonElement(serializer, value)
                    } catch (_: Exception) {
                        // Fallback for unknown types — just use toString
                        JsonPrimitive(value.toString())
                    }
                }
            }
        }
    }

    private val logger = getLogger(this)
    private val tracer = getTracerOrNull(this)

    private val closed = AtomicBoolean()
    private val invocationFutures: MutableMap<Long, InvocationFuture> = ConcurrentHashMap()
    private val eventListeners: ConcurrentHashMap<String, ConcurrentSkipListSet<DevToolsEventListener>> =
        ConcurrentHashMap()

    private val eventDispatcherScope = CoroutineScope(Dispatchers.Default) + CoroutineName("EventDispatcher")

    val isActive get() = !closed.get()

    /** Serialize a [MethodInvocation] to a JSON-RPC request string. */
    fun serialize(method: MethodInvocation): String {
        return JSON.encodeToString(
            buildJsonObject {
                put(ID_PROPERTY, method.id)
                put(METHOD_PROPERTY, method.method)
                if (method.params != null) {
                    put(PARAMS_PROPERTY, toJsonElement(method.params))
                }
            }
        )
    }

    /** Serialize a CDP request from its constituent parts. */
    fun serialize(id: Long, method: String, params: Map<String, Any>?, sessionId: String?): String {
        return JSON.encodeToString(
            buildJsonObject {
                put(ID_PROPERTY, id)
                put(METHOD_PROPERTY, method)
                if (params != null) {
                    put(PARAMS_PROPERTY, toJsonElement(params))
                }
                if (sessionId != null) {
                    put("sessionId", sessionId)
                }
            }
        )
    }

    @Suppress("UNCHECKED_CAST")
    @Throws(IOException::class)
    fun <T> deserialize(classParameters: Array<Class<*>>, parameterizedClazz: Class<T>, jsonElement: JsonElement): T {
        val elementSerializer = serializerFor(parameterizedClazz)

        val serializer: KSerializer<T> = when {
            classParameters.isEmpty() -> elementSerializer

            // Single-parameter generics (List-like). Support nesting via right fold.
            // e.g., classParameters: [List, Double] with parameterizedClazz: List → List<List<Double>>
            classParameters.size == 1 -> {
                val inner = serializerFor(classParameters[0])
                listSerializer(inner) as KSerializer<T>
            }

            // Two or more parameters — handle nested generics
            else -> {
                var current: KSerializer<*> = serializerFor(classParameters.last())
                for (i in classParameters.size - 2 downTo 0) {
                    val outerClass = classParameters[i]
                    current = when {
                        outerClass == List::class.java -> listSerializer(current)
                        Map::class.java.isAssignableFrom(outerClass) -> mapSerializer(current)
                        else -> elementSerializer // fallback
                    }
                }
                current as KSerializer<T>
            }
        }

        return JSON.decodeFromJsonElement(serializer, jsonElement)
    }

    /**
     * A typical Server Side Event:
     * ```json
     * {"method":"Page.frameStartedLoading","params":{"frameId":"53F48CA08C50A3A72887CB9F15B293D5"}}
     * ```
     */
    @Throws(IOException::class, ChromeRPCException::class)
    fun <T> deserialize(clazz: Class<T>, jsonElement: JsonElement?): T {
        if (jsonElement == null) {
            throw ChromeRPCException("Failed converting null response to clazz " + clazz.name)
        }

        try {
            val serializer = serializerFor(clazz)
            return JSON.decodeFromJsonElement(serializer, jsonElement)
        } catch (e: Exception) {
            val message = """
                Failed converting response to clazz ${clazz.name}
                $jsonElement
            """.trimIndent()
            logger.warn(message, e)
            throw ChromeRPCException("Failed to deserialize ${clazz.name}", e)
        }
    }

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

    @Throws(ChromeRPCException::class, IOException::class)
    override fun accept(message: String) {
        tracer?.trace("◀ Accept {}", StringUtils.abbreviateMiddle(message, "...", 20000))

        ChromeDevToolsImpl.numAccepts.inc()
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
                            resultElement = resultElement?.jsonObject?.get(future.returnProperty)
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
        }
    }

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
     */
    private suspend fun handleEvent0(params: JsonElement?, unmodifiedListeners: Iterable<DevToolsEventListener>) {
        try {
            handleEvent1(params, unmodifiedListeners)
        } catch (e: Exception) {
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

            try {
                listener.handler.onEvent(event!!)
            } catch (e: Exception) {
                logger.warn(
                    "Failed to handle event, rethrow ChromeRPCException. " +
                        "Enable debug logging to see the stack trace | {}",
                    e.message
                )
                logger.debug("Failed to handle event", e)
                throw ChromeRPCException("Failed to handle event | ${listener.key}, ${listener.paramType}", e)
            }
        }
    }
}
