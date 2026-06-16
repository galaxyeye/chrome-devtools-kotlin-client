@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.dom

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Physical scroll orientation
 */
public enum class ScrollOrientation {
  @JsonProperty("horizontal")
  HORIZONTAL,
  @JsonProperty("vertical")
  VERTICAL,
  @JsonEnumDefaultValue
  UNKNOWN,
}
