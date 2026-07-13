@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * How the session was used (or not used).
 */
@Serializable
public enum class DeviceBoundSessionWithUsageUsage {
  @SerialName("NotInScope")
  NOT_IN_SCOPE,
  @SerialName("InScopeRefreshNotYetNeeded")
  IN_SCOPE_REFRESH_NOT_YET_NEEDED,
  @SerialName("InScopeRefreshNotAllowed")
  IN_SCOPE_REFRESH_NOT_ALLOWED,
  @SerialName("ProactiveRefreshNotPossible")
  PROACTIVE_REFRESH_NOT_POSSIBLE,
  @SerialName("ProactiveRefreshAttempted")
  PROACTIVE_REFRESH_ATTEMPTED,
  @SerialName("Deferred")
  DEFERRED,
  UNKNOWN,
}
