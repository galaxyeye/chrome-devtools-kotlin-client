@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.bluetoothemulation

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Stores the advertisement packet information that is sent by a Bluetooth device.
 */
data class ScanEntry(
  @param:JsonProperty("deviceAddress")
  val deviceAddress: String,
  @param:JsonProperty("rssi")
  val rssi: Int,
  @param:JsonProperty("scanRecord")
  val scanRecord: ScanRecord,
)
