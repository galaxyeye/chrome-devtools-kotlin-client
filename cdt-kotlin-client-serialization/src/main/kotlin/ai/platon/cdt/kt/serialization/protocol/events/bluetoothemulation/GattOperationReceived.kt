@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.bluetoothemulation

import ai.platon.cdt.kt.serialization.protocol.types.bluetoothemulation.GATTOperationType
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Event for when a GATT operation of |type| to the peripheral with |address|
 * happened.
 */
@Serializable
data class GattOperationReceived(
  @property:SerialName("address")
  val address: String,
  @property:SerialName("type")
  val type: GATTOperationType,
)
