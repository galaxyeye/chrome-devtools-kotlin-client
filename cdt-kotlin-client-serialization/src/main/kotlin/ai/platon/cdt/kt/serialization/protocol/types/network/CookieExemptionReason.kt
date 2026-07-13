@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Types of reasons why a cookie should have been blocked by 3PCD but is exempted for the request.
 */
@Serializable
public enum class CookieExemptionReason {
  @SerialName("None")
  NONE,
  @SerialName("UserSetting")
  USER_SETTING,
  @SerialName("TPCDMetadata")
  TPCD_METADATA,
  @SerialName("TPCDDeprecationTrial")
  TPCD_DEPRECATION_TRIAL,
  @SerialName("TopLevelTPCDDeprecationTrial")
  TOP_LEVEL_TPCD_DEPRECATION_TRIAL,
  @SerialName("TPCDHeuristics")
  TPCD_HEURISTICS,
  @SerialName("EnterprisePolicy")
  ENTERPRISE_POLICY,
  @SerialName("StorageAccess")
  STORAGE_ACCESS,
  @SerialName("TopLevelStorageAccess")
  TOP_LEVEL_STORAGE_ACCESS,
  @SerialName("Scheme")
  SCHEME,
  @SerialName("SameSiteNoneCookiesInSandbox")
  SAME_SITE_NONE_COOKIES_IN_SANDBOX,
  UNKNOWN,
}
