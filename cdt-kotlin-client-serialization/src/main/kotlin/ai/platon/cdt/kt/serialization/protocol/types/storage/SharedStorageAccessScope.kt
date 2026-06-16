@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.storage

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Enum of shared storage access scopes.
 */
@Serializable
public enum class SharedStorageAccessScope {
  @SerialName("window")
  WINDOW,
  @SerialName("sharedStorageWorklet")
  SHARED_STORAGE_WORKLET,
  @SerialName("protectedAudienceWorklet")
  PROTECTED_AUDIENCE_WORKLET,
  @SerialName("header")
  HEADER,
  UNKNOWN,
}
