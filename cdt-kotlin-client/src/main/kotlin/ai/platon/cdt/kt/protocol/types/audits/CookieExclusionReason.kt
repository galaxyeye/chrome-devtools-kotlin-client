@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class CookieExclusionReason {
  @JsonProperty("ExcludeSameSiteUnspecifiedTreatedAsLax")
  EXCLUDE_SAME_SITE_UNSPECIFIED_TREATED_AS_LAX,
  @JsonProperty("ExcludeSameSiteNoneInsecure")
  EXCLUDE_SAME_SITE_NONE_INSECURE,
  @JsonProperty("ExcludeSameSiteLax")
  EXCLUDE_SAME_SITE_LAX,
  @JsonProperty("ExcludeSameSiteStrict")
  EXCLUDE_SAME_SITE_STRICT,
  @JsonProperty("ExcludeDomainNonASCII")
  EXCLUDE_DOMAIN_NON_ASCII,
  @JsonProperty("ExcludeThirdPartyCookieBlockedInFirstPartySet")
  EXCLUDE_THIRD_PARTY_COOKIE_BLOCKED_IN_FIRST_PARTY_SET,
  @JsonProperty("ExcludeThirdPartyPhaseout")
  EXCLUDE_THIRD_PARTY_PHASEOUT,
  @JsonProperty("ExcludePortMismatch")
  EXCLUDE_PORT_MISMATCH,
  @JsonProperty("ExcludeSchemeMismatch")
  EXCLUDE_SCHEME_MISMATCH,
  @JsonEnumDefaultValue
  UNKNOWN,
}
