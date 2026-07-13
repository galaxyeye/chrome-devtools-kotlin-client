@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.bluetoothemulation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Indicates the various types of characteristic write.
 */
@Serializable
public enum class CharacteristicWriteType {
  @SerialName("write-default-deprecated")
  WRITE_DEFAULT_DEPRECATED,
  @SerialName("write-with-response")
  WRITE_WITH_RESPONSE,
  @SerialName("write-without-response")
  WRITE_WITHOUT_RESPONSE,
  UNKNOWN,
}
