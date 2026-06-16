@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * The render-blocking behavior of a resource request.
 */
public enum class RenderBlockingBehavior {
  @JsonProperty("Blocking")
  BLOCKING,
  @JsonProperty("InBodyParserBlocking")
  IN_BODY_PARSER_BLOCKING,
  @JsonProperty("NonBlocking")
  NON_BLOCKING,
  @JsonProperty("NonBlockingDynamic")
  NON_BLOCKING_DYNAMIC,
  @JsonProperty("PotentiallyBlocking")
  POTENTIALLY_BLOCKING,
  @JsonEnumDefaultValue
  UNKNOWN,
}
