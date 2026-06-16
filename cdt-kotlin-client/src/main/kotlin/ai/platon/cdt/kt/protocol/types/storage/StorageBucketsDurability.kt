@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.storage

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class StorageBucketsDurability {
  @JsonProperty("relaxed")
  RELAXED,
  @JsonProperty("strict")
  STRICT,
  @JsonEnumDefaultValue
  UNKNOWN,
}
