@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.bluetoothemulation

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Stores the byte data of the advertisement packet sent by a Bluetooth device.
 */
@Serializable
data class ScanRecord(
  @property:SerialName("name")
  @param:Optional
  val name: String? = null,
  @property:SerialName("uuids")
  @param:Optional
  val uuids: List<String>? = null,
  @property:SerialName("appearance")
  @param:Optional
  val appearance: Int? = null,
  @property:SerialName("txPower")
  @param:Optional
  val txPower: Int? = null,
  @property:SerialName("manufacturerData")
  @param:Optional
  val manufacturerData: List<ManufacturerData>? = null,
)
