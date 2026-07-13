@file:OptIn(InternalSerializationApi::class)

package ai.platon.pulsar.browser.driver.chrome.impl

import ai.platon.pulsar.browser.driver.chrome.MethodInvocation
import ai.platon.pulsar.browser.driver.chrome.util.ChromeRPCException
import ai.platon.pulsar.common.getLogger
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.json.*
import kotlinx.serialization.serializer
import java.io.IOException

/**
 * Handles CDP wire-format JSON serialization and deserialization via kotlinx.serialization.
 *
 * Extracted from [EventDispatcher] to separate message codec concerns from
 * future management, event listener registry, and incoming-message routing.
 */
class CdpMessageCodec {

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

    /**
     * Patch protocol changes if needed (e.g. renamed fields across Chrome versions).
     */
    fun patchMessageForProtocolChange(message: String, force: Boolean = false): String {
        var patched = message
        if (force || patched.contains("clientSecurityState")) {
            patched = patched.replace("clientSecurityState", "clientSecurityState-Deleted")
        }
        return patched
    }

    // ---------------------------------------------------------------------------
    // Serialization
    // ---------------------------------------------------------------------------

    /**
     * Serializes a [MethodInvocation] into a CDP wire-format JSON string.
     * Other [@Serializable][kotlinx.serialization.Serializable] objects are serialized via kotlinx.serialization.
     */
    fun serialize(message: Any): String {
        return when (message) {
            is MethodInvocation -> serialize(message.id, message.method, message.params, null)
            else -> {
                @Suppress("UNCHECKED_CAST")
                val serializer = message::class.serializer() as KSerializer<Any>
                JSON.encodeToString(serializer, message)
            }
        }
    }

    /**
     * Builds the CDP wire-format JSON message:
     * `{"id":..., "method":..., "params":..., "sessionId":...}`
     */
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

    // ---------------------------------------------------------------------------
    // Deserialization
    // ---------------------------------------------------------------------------

    /**
     * Deserializes a [JsonElement] into a parameterized type (e.g. `List<Cookie>`, `List<List<Double>>`).
     */
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
     * Deserializes a [JsonElement] into a plain (non-generic) class.
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
}
