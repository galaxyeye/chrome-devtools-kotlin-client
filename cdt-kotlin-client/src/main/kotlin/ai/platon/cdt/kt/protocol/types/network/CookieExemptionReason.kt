@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Types of reasons why a cookie should have been blocked by 3PCD but is exempted for the request.
 */
public enum class CookieExemptionReason {
  @JsonProperty("None")
  NONE,
  @JsonProperty("UserSetting")
  USER_SETTING,
  @JsonProperty("TPCDMetadata")
  TPCD_METADATA,
  @JsonProperty("TPCDDeprecationTrial")
  TPCD_DEPRECATION_TRIAL,
  @JsonProperty("TopLevelTPCDDeprecationTrial")
  TOP_LEVEL_TPCD_DEPRECATION_TRIAL,
  @JsonProperty("TPCDHeuristics")
  TPCD_HEURISTICS,
  @JsonProperty("EnterprisePolicy")
  ENTERPRISE_POLICY,
  @JsonProperty("StorageAccess")
  STORAGE_ACCESS,
  @JsonProperty("TopLevelStorageAccess")
  TOP_LEVEL_STORAGE_ACCESS,
  @JsonProperty("Scheme")
  SCHEME,
  @JsonProperty("SameSiteNoneCookiesInSandbox")
  SAME_SITE_NONE_COOKIES_IN_SANDBOX,
  @JsonEnumDefaultValue
  UNKNOWN,
}
