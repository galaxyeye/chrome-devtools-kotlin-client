@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.emulation

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Current posture of the device
 */
public enum class DevicePostureType {
  @JsonProperty("continuous")
  CONTINUOUS,
  @JsonProperty("folded")
  FOLDED,
  @JsonEnumDefaultValue
  UNKNOWN,
}
