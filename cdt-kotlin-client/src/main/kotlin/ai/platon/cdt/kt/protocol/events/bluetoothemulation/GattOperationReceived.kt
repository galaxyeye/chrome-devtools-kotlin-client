@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.bluetoothemulation

import ai.platon.cdt.kt.protocol.types.bluetoothemulation.GATTOperationType
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Event for when a GATT operation of |type| to the peripheral with |address|
 * happened.
 */
data class GattOperationReceived(
  @param:JsonProperty("address")
  val address: String,
  @param:JsonProperty("type")
  val type: GATTOperationType,
)
