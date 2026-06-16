@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Current posture of the device
 */
@Serializable
public enum class DevicePostureType {
  @SerialName("continuous")
  CONTINUOUS,
  @SerialName("folded")
  FOLDED,
  UNKNOWN,
}
