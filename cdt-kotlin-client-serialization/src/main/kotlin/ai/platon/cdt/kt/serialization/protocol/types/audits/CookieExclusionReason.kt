@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class CookieExclusionReason {
  @SerialName("ExcludeSameSiteUnspecifiedTreatedAsLax")
  EXCLUDE_SAME_SITE_UNSPECIFIED_TREATED_AS_LAX,
  @SerialName("ExcludeSameSiteNoneInsecure")
  EXCLUDE_SAME_SITE_NONE_INSECURE,
  @SerialName("ExcludeSameSiteLax")
  EXCLUDE_SAME_SITE_LAX,
  @SerialName("ExcludeSameSiteStrict")
  EXCLUDE_SAME_SITE_STRICT,
  @SerialName("ExcludeDomainNonASCII")
  EXCLUDE_DOMAIN_NON_ASCII,
  @SerialName("ExcludeThirdPartyCookieBlockedInFirstPartySet")
  EXCLUDE_THIRD_PARTY_COOKIE_BLOCKED_IN_FIRST_PARTY_SET,
  @SerialName("ExcludeThirdPartyPhaseout")
  EXCLUDE_THIRD_PARTY_PHASEOUT,
  @SerialName("ExcludePortMismatch")
  EXCLUDE_PORT_MISMATCH,
  @SerialName("ExcludeSchemeMismatch")
  EXCLUDE_SCHEME_MISMATCH,
  UNKNOWN,
}
