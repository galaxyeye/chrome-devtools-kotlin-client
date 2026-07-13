@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.dom

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * ContainerSelector physical axes
 */
public enum class PhysicalAxes {
  @JsonProperty("Horizontal")
  HORIZONTAL,
  @JsonProperty("Vertical")
  VERTICAL,
  @JsonProperty("Both")
  BOTH,
  @JsonEnumDefaultValue
  UNKNOWN,
}
