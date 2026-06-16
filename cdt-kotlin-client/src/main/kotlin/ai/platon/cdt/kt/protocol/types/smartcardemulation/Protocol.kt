@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.smartcardemulation

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Maps to the |SCARD_PROTOCOL_*| values.
 */
public enum class Protocol {
  @JsonProperty("t0")
  T_0,
  @JsonProperty("t1")
  T_1,
  @JsonProperty("raw")
  RAW,
  @JsonEnumDefaultValue
  UNKNOWN,
}
