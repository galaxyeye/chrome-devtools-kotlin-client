@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.bluetoothemulation

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Indicates the various types of characteristic write.
 */
public enum class CharacteristicWriteType {
  @JsonProperty("write-default-deprecated")
  WRITE_DEFAULT_DEPRECATED,
  @JsonProperty("write-with-response")
  WRITE_WITH_RESPONSE,
  @JsonProperty("write-without-response")
  WRITE_WITHOUT_RESPONSE,
  @JsonEnumDefaultValue
  UNKNOWN,
}
