@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.emulation

import com.fasterxml.jackson.`annotation`.JsonProperty

data class DevicePosture(
  @param:JsonProperty("type")
  val type: DevicePostureType,
)
