@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.bluetoothemulation

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Indicates the various types of characteristic operation.
 */
public enum class CharacteristicOperationType {
  @JsonProperty("read")
  READ,
  @JsonProperty("write")
  WRITE,
  @JsonProperty("subscribe-to-notifications")
  SUBSCRIBE_TO_NOTIFICATIONS,
  @JsonProperty("unsubscribe-from-notifications")
  UNSUBSCRIBE_FROM_NOTIFICATIONS,
  @JsonEnumDefaultValue
  UNKNOWN,
}
