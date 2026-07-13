@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * How the session was used (or not used).
 */
public enum class DeviceBoundSessionWithUsageUsage {
  @JsonProperty("NotInScope")
  NOT_IN_SCOPE,
  @JsonProperty("InScopeRefreshNotYetNeeded")
  IN_SCOPE_REFRESH_NOT_YET_NEEDED,
  @JsonProperty("InScopeRefreshNotAllowed")
  IN_SCOPE_REFRESH_NOT_ALLOWED,
  @JsonProperty("ProactiveRefreshNotPossible")
  PROACTIVE_REFRESH_NOT_POSSIBLE,
  @JsonProperty("ProactiveRefreshAttempted")
  PROACTIVE_REFRESH_ATTEMPTED,
  @JsonProperty("Deferred")
  DEFERRED,
  @JsonEnumDefaultValue
  UNKNOWN,
}
