@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class SameSiteCookieExclusionReason {
  @SerialName("ExcludeSameSiteUnspecifiedTreatedAsLax")
  EXCLUDE_SAME_SITE_UNSPECIFIED_TREATED_AS_LAX,
  @SerialName("ExcludeSameSiteNoneInsecure")
  EXCLUDE_SAME_SITE_NONE_INSECURE,
  @SerialName("ExcludeSameSiteLax")
  EXCLUDE_SAME_SITE_LAX,
  @SerialName("ExcludeSameSiteStrict")
  EXCLUDE_SAME_SITE_STRICT,
  UNKNOWN,
}
