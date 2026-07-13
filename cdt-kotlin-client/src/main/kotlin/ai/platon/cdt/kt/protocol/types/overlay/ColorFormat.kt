@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.overlay

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class ColorFormat {
  @JsonProperty("rgb")
  RGB,
  @JsonProperty("hsl")
  HSL,
  @JsonProperty("hwb")
  HWB,
  @JsonProperty("hex")
  HEX,
  @JsonEnumDefaultValue
  UNKNOWN,
}
