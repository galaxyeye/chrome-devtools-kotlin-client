@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.bluetoothemulation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Indicates the various types of descriptor operation.
 */
@Serializable
public enum class DescriptorOperationType {
  @SerialName("read")
  READ,
  @SerialName("write")
  WRITE,
  UNKNOWN,
}
