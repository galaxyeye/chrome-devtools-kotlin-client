@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.dom

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * ContainerSelector logical axes
 */
public enum class LogicalAxes {
  @JsonProperty("Inline")
  INLINE,
  @JsonProperty("Block")
  BLOCK,
  @JsonProperty("Both")
  BOTH,
  @JsonEnumDefaultValue
  UNKNOWN,
}
