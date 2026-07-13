@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class SerializationOptionsSerialization {
  @SerialName("deep")
  DEEP,
  @SerialName("json")
  JSON,
  @SerialName("idOnly")
  ID_ONLY,
  UNKNOWN,
}
