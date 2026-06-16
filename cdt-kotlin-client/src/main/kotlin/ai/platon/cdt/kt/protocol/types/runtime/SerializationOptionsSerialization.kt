@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.runtime

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class SerializationOptionsSerialization {
  @JsonProperty("deep")
  DEEP,
  @JsonProperty("json")
  JSON,
  @JsonProperty("idOnly")
  ID_ONLY,
  @JsonEnumDefaultValue
  UNKNOWN,
}
