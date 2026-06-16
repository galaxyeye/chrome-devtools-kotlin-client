@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.bluetoothemulation

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Stores the advertisement packet information that is sent by a Bluetooth device.
 */
@Serializable
data class ScanEntry(
  @property:SerialName("deviceAddress")
  val deviceAddress: String,
  @property:SerialName("rssi")
  val rssi: Int,
  @property:SerialName("scanRecord")
  val scanRecord: ScanRecord,
)
