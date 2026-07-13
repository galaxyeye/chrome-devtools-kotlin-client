@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * The reason for a session being deleted.
 */
public enum class TerminationEventDetailsDeletionReason {
  @JsonProperty("Expired")
  EXPIRED,
  @JsonProperty("FailedToRestoreKey")
  FAILED_TO_RESTORE_KEY,
  @JsonProperty("FailedToUnwrapKey")
  FAILED_TO_UNWRAP_KEY,
  @JsonProperty("StoragePartitionCleared")
  STORAGE_PARTITION_CLEARED,
  @JsonProperty("ClearBrowsingData")
  CLEAR_BROWSING_DATA,
  @JsonProperty("ServerRequested")
  SERVER_REQUESTED,
  @JsonProperty("InvalidSessionParams")
  INVALID_SESSION_PARAMS,
  @JsonProperty("RefreshFatalError")
  REFRESH_FATAL_ERROR,
  @JsonProperty("DevTools")
  DEV_TOOLS,
  @JsonEnumDefaultValue
  UNKNOWN,
}
