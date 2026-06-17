package ai.platon.browser4.chrome.util

import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.*

/**
 * Serializes [Map]<[String], [Any]> as a JSON object, where values are primitives,
 * strings, lists, or nested maps — things that can be represented as [JsonElement].
 *
 * Falls back to string representation for values that don't map cleanly to JSON primitives.
 */
object MapStringAnySerializer : KSerializer<Map<String, Any>> {
    override val descriptor: SerialDescriptor =
        MapSerializer(String.serializer(), JsonElement.serializer()).descriptor

    override fun serialize(encoder: Encoder, value: Map<String, Any>) {
        val jsonObject = buildJsonObject {
            value.forEach { (k, v) -> put(k, anyToJsonElement(v)) }
        }
        encoder.encodeSerializableValue(JsonObject.serializer(), jsonObject)
    }

    @Suppress("UNCHECKED_CAST")
    override fun deserialize(decoder: Decoder): Map<String, Any> {
        val jsonObject = decoder.decodeSerializableValue(JsonObject.serializer())
        return jsonObject.mapValues { (_, v) -> jsonElementToAny(v) } as Map<String, Any>
    }

    private fun anyToJsonElement(value: Any): JsonElement = when (value) {
        null -> JsonNull
        is JsonElement -> value
        is String -> JsonPrimitive(value)
        is Number -> JsonPrimitive(value)
        is Boolean -> JsonPrimitive(value)
        is Enum<*> -> JsonPrimitive(value.name)
        is Map<*, *> -> buildJsonObject {
            value.forEach { (k, v) -> put(k.toString(), anyToJsonElement(v!!)) }
        }
        is List<*> -> buildJsonArray {
            value.forEach { add(anyToJsonElement(it!!)) }
        }
        else -> JsonPrimitive(value.toString())
    }

    private fun jsonElementToAny(element: JsonElement): Any = when (element) {
        is JsonNull -> "null"
        is JsonPrimitive -> {
            if (element.isString) element.content
            else element.booleanOrNull ?: element.longOrNull ?: element.doubleOrNull ?: element.content
        }
        is JsonObject -> element.mapValues { (_, v) -> jsonElementToAny(v) }
        is JsonArray -> element.map { jsonElementToAny(it) }
    }
}
