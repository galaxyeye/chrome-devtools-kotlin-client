@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * The result of a refresh.
 */
public enum class RefreshEventDetailsRefreshResult {
  @JsonProperty("Refreshed")
  REFRESHED,
  @JsonProperty("InitializedService")
  INITIALIZED_SERVICE,
  @JsonProperty("Unreachable")
  UNREACHABLE,
  @JsonProperty("ServerError")
  SERVER_ERROR,
  @JsonProperty("RefreshQuotaExceeded")
  REFRESH_QUOTA_EXCEEDED,
  @JsonProperty("FatalError")
  FATAL_ERROR,
  @JsonProperty("SigningQuotaExceeded")
  SIGNING_QUOTA_EXCEEDED,
  @JsonProperty("RefreshedAsWaiter")
  REFRESHED_AS_WAITER,
  @JsonProperty("TransientSigningError")
  TRANSIENT_SIGNING_ERROR,
  @JsonEnumDefaultValue
  UNKNOWN,
}
