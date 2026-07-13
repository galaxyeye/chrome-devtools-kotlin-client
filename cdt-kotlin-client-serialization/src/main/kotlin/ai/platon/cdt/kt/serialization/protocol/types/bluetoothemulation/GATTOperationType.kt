@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.bluetoothemulation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Indicates the various types of GATT event.
 */
@Serializable
public enum class GATTOperationType {
  @SerialName("connection")
  CONNECTION,
  @SerialName("discovery")
  DISCOVERY,
  UNKNOWN,
}
