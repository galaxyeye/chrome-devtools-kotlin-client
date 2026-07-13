package ai.platon.browser4.chrome.protocol

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

/**
 * Type-safe model of the Chrome DevTools Protocol definition JSON
 * (`browser_protocol.json` / `js_protocol.json`).
 *
 * Only the fields needed for command/event conformance validation are parsed;
 * unknown JSON keys are silently ignored.
 */
@Serializable
data class ProtocolSpec(
    val version: ProtocolVersion,
    val domains: List<DomainSpec>
)

@Serializable
data class ProtocolVersion(
    val major: String,
    val minor: String
)

@Serializable
data class DomainSpec(
    val domain: String,
    val commands: List<CommandSpec> = emptyList(),
    val events: List<EventSpec> = emptyList()
)

@Serializable
data class CommandSpec(
    val name: String,
    val parameters: List<ParameterSpec> = emptyList(),
    val returns: List<ParameterSpec> = emptyList()
)

@Serializable
data class EventSpec(
    val name: String,
    val parameters: List<ParameterSpec> = emptyList()
)

/**
 * A parameter (or return value) in a CDP command or event.
 *
 * Handles all three JSON shapes:
 * - Simple typed:   `{"name": "url", "type": "string"}`
 * - Type reference:  `{"name": "nodeId", "$ref": "DOM.NodeId"}`
 * - Optional:        `{"name": "depth", "type": "integer", "optional": true}`
 */
@Serializable
data class ParameterSpec(
    val name: String,
    val type: String? = null,
    @SerialName("\$ref") val ref: String? = null,
    val optional: Boolean = false
)

/** Lightweight descriptor of a CDP command call for conformance validation. */
data class CdpCall(
    val method: String,
    /** Param names; suffix with `?` for optional params (omitted when null in Kotlin DSL). */
    val params: List<String> = emptyList(),
    /** When a `returnProperty` is specified in the Kotlin code. */
    val returnProperty: String? = null
)

/** Lightweight descriptor of a CDP event subscription for conformance validation. */
data class CdpEvent(
    val domain: String,
    val event: String
)

/** JSON instance configured to ignore unknown keys in the protocol definitions. */
internal val cdpJson = Json {
    ignoreUnknownKeys = true
    isLenient = true
}
