@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.bluetoothemulation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Indicates the various states of Central.
 */
@Serializable
public enum class CentralState {
  @SerialName("absent")
  ABSENT,
  @SerialName("powered-off")
  POWERED_OFF,
  @SerialName("powered-on")
  POWERED_ON,
  UNKNOWN,
}
