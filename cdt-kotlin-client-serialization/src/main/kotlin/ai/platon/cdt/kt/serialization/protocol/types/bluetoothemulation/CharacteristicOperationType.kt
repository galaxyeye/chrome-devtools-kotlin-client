@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.bluetoothemulation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Indicates the various types of characteristic operation.
 */
@Serializable
public enum class CharacteristicOperationType {
  @SerialName("read")
  READ,
  @SerialName("write")
  WRITE,
  @SerialName("subscribe-to-notifications")
  SUBSCRIBE_TO_NOTIFICATIONS,
  @SerialName("unsubscribe-from-notifications")
  UNSUBSCRIBE_FROM_NOTIFICATIONS,
  UNKNOWN,
}
