@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.dom

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Whether to include whitespaces in the children array of returned Nodes.
 */
public enum class EnableIncludeWhitespace {
  @JsonProperty("none")
  NONE,
  @JsonProperty("all")
  ALL,
  @JsonEnumDefaultValue
  UNKNOWN,
}
