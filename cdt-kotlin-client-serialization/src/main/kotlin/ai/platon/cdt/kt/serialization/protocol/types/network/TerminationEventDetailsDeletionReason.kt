@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The reason for a session being deleted.
 */
@Serializable
public enum class TerminationEventDetailsDeletionReason {
  @SerialName("Expired")
  EXPIRED,
  @SerialName("FailedToRestoreKey")
  FAILED_TO_RESTORE_KEY,
  @SerialName("FailedToUnwrapKey")
  FAILED_TO_UNWRAP_KEY,
  @SerialName("StoragePartitionCleared")
  STORAGE_PARTITION_CLEARED,
  @SerialName("ClearBrowsingData")
  CLEAR_BROWSING_DATA,
  @SerialName("ServerRequested")
  SERVER_REQUESTED,
  @SerialName("InvalidSessionParams")
  INVALID_SESSION_PARAMS,
  @SerialName("RefreshFatalError")
  REFRESH_FATAL_ERROR,
  @SerialName("DevTools")
  DEV_TOOLS,
  UNKNOWN,
}
