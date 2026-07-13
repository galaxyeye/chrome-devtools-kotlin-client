@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.bluetoothemulation

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Indicates the various types of descriptor operation.
 */
public enum class DescriptorOperationType {
  @JsonProperty("read")
  READ,
  @JsonProperty("write")
  WRITE,
  @JsonEnumDefaultValue
  UNKNOWN,
}
