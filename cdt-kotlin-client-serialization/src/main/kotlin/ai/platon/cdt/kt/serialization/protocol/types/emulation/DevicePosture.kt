@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DevicePosture(
  @property:SerialName("type")
  val type: DevicePostureType,
)
