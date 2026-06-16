@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.emulation

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class PressureState {
  @JsonProperty("nominal")
  NOMINAL,
  @JsonProperty("fair")
  FAIR,
  @JsonProperty("serious")
  SERIOUS,
  @JsonProperty("critical")
  CRITICAL,
  @JsonEnumDefaultValue
  UNKNOWN,
}
