@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The result of a refresh.
 */
@Serializable
public enum class RefreshEventDetailsRefreshResult {
  @SerialName("Refreshed")
  REFRESHED,
  @SerialName("InitializedService")
  INITIALIZED_SERVICE,
  @SerialName("Unreachable")
  UNREACHABLE,
  @SerialName("ServerError")
  SERVER_ERROR,
  @SerialName("RefreshQuotaExceeded")
  REFRESH_QUOTA_EXCEEDED,
  @SerialName("FatalError")
  FATAL_ERROR,
  @SerialName("SigningQuotaExceeded")
  SIGNING_QUOTA_EXCEEDED,
  @SerialName("RefreshedAsWaiter")
  REFRESHED_AS_WAITER,
  @SerialName("TransientSigningError")
  TRANSIENT_SIGNING_ERROR,
  UNKNOWN,
}
