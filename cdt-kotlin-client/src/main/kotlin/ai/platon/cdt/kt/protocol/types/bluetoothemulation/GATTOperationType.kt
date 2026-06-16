@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.bluetoothemulation

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Indicates the various types of GATT event.
 */
public enum class GATTOperationType {
  @JsonProperty("connection")
  CONNECTION,
  @JsonProperty("discovery")
  DISCOVERY,
  @JsonEnumDefaultValue
  UNKNOWN,
}
