@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.storage

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Enum of shared storage access scopes.
 */
public enum class SharedStorageAccessScope {
  @JsonProperty("window")
  WINDOW,
  @JsonProperty("sharedStorageWorklet")
  SHARED_STORAGE_WORKLET,
  @JsonProperty("protectedAudienceWorklet")
  PROTECTED_AUDIENCE_WORKLET,
  @JsonProperty("header")
  HEADER,
  @JsonEnumDefaultValue
  UNKNOWN,
}
