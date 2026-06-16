@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.smartcardemulation

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Maps to |SCARD_*| connection state values.
 */
public enum class ConnectionState {
  @JsonProperty("absent")
  ABSENT,
  @JsonProperty("present")
  PRESENT,
  @JsonProperty("swallowed")
  SWALLOWED,
  @JsonProperty("powered")
  POWERED,
  @JsonProperty("negotiable")
  NEGOTIABLE,
  @JsonProperty("specific")
  SPECIFIC,
  @JsonEnumDefaultValue
  UNKNOWN,
}
