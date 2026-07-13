@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.bluetoothemulation

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Stores the byte data of the advertisement packet sent by a Bluetooth device.
 */
data class ScanRecord(
  @param:JsonProperty("name")
  @param:Optional
  val name: String? = null,
  @param:JsonProperty("uuids")
  @param:Optional
  val uuids: List<String>? = null,
  @param:JsonProperty("appearance")
  @param:Optional
  val appearance: Int? = null,
  @param:JsonProperty("txPower")
  @param:Optional
  val txPower: Int? = null,
  @param:JsonProperty("manufacturerData")
  @param:Optional
  val manufacturerData: List<ManufacturerData>? = null,
)
