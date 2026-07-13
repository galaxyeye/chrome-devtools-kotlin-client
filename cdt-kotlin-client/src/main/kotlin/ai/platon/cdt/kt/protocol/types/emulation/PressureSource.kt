@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.emulation

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class PressureSource {
  @JsonProperty("cpu")
  CPU,
  @JsonEnumDefaultValue
  UNKNOWN,
}
