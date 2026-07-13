@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.bluetoothemulation

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Indicates the various states of Central.
 */
public enum class CentralState {
  @JsonProperty("absent")
  ABSENT,
  @JsonProperty("powered-off")
  POWERED_OFF,
  @JsonProperty("powered-on")
  POWERED_ON,
  @JsonEnumDefaultValue
  UNKNOWN,
}
