package ai.platon.browser4.chrome.util

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.encodeToJsonElement

/**
 * Shared [Json] instance for general-purpose serialization.
 * Mirrors [ai.platon.browser4.chrome.protocol.transport.EventDispatcher.JSON]
 * configuration to ensure consistent behavior across the module.
 */
val json = Json {
    ignoreUnknownKeys = true
    isLenient = true
    coerceInputValues = true
    encodeDefaults = true
}

/**
 * Pretty-printing [Json] instance for human-readable output (launch reports, debug logs).
 */
val prettyJson = Json {
    ignoreUnknownKeys = true
    isLenient = true
    coerceInputValues = true
    encodeDefaults = true
    prettyPrint = true
}

/**
 * Encodes a Kotlin [String] into its JSON string literal representation,
 * including surrounding double quotes and proper escaping.
 * Equivalent to Jackson's ObjectMapper.writeValueAsString(str) or Pson.toJson(str).
 *
 * Example: `encodeJsonString("hello")` → `"\"hello\""` (the JSON string `"hello"`)
 */
fun encodeJsonString(value: String): String {
    return json.encodeToString(JsonPrimitive(value))
}

/**
 * Converts a [Map]<[String], [Any]?> to its JSON string representation.
 * Handles String, Number, Boolean, null, nested Map, and nested List values.
 */
fun mapToJsonString(map: Map<String, Any?>): String {
    return json.encodeToString(buildJsonObject {
        map.forEach { (k, v) -> put(k, anyToJsonElement(v)) }
    })
}

/**
 * Converts an arbitrary value to a [JsonPrimitive] or nested [JsonObject]/[JsonArray].
 * Used as a lightweight alternative to Jackson's ObjectMapper for simple map serialization.
 */
fun anyToJsonElement(value: Any?): kotlinx.serialization.json.JsonElement = when (value) {
    null -> kotlinx.serialization.json.JsonNull
    is kotlinx.serialization.json.JsonElement -> value
    is String -> JsonPrimitive(value)
    is Number -> JsonPrimitive(value)
    is Boolean -> JsonPrimitive(value)
    is Enum<*> -> JsonPrimitive(value.name)
    is Map<*, *> -> buildJsonObject {
        value.forEach { (k, v) -> put(k.toString(), anyToJsonElement(v)) }
    }
    is List<*> -> kotlinx.serialization.json.buildJsonArray {
        value.forEach { add(anyToJsonElement(it)) }
    }
    is Array<*> -> kotlinx.serialization.json.buildJsonArray {
        value.forEach { add(anyToJsonElement(it)) }
    }
    else -> JsonPrimitive(value.toString())
}
