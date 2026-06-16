@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class CookieWarningReason {
  @JsonProperty("WarnSameSiteUnspecifiedCrossSiteContext")
  WARN_SAME_SITE_UNSPECIFIED_CROSS_SITE_CONTEXT,
  @JsonProperty("WarnSameSiteNoneInsecure")
  WARN_SAME_SITE_NONE_INSECURE,
  @JsonProperty("WarnSameSiteUnspecifiedLaxAllowUnsafe")
  WARN_SAME_SITE_UNSPECIFIED_LAX_ALLOW_UNSAFE,
  @JsonProperty("WarnSameSiteStrictLaxDowngradeStrict")
  WARN_SAME_SITE_STRICT_LAX_DOWNGRADE_STRICT,
  @JsonProperty("WarnSameSiteStrictCrossDowngradeStrict")
  WARN_SAME_SITE_STRICT_CROSS_DOWNGRADE_STRICT,
  @JsonProperty("WarnSameSiteStrictCrossDowngradeLax")
  WARN_SAME_SITE_STRICT_CROSS_DOWNGRADE_LAX,
  @JsonProperty("WarnSameSiteLaxCrossDowngradeStrict")
  WARN_SAME_SITE_LAX_CROSS_DOWNGRADE_STRICT,
  @JsonProperty("WarnSameSiteLaxCrossDowngradeLax")
  WARN_SAME_SITE_LAX_CROSS_DOWNGRADE_LAX,
  @JsonProperty("WarnAttributeValueExceedsMaxSize")
  WARN_ATTRIBUTE_VALUE_EXCEEDS_MAX_SIZE,
  @JsonProperty("WarnDomainNonASCII")
  WARN_DOMAIN_NON_ASCII,
  @JsonProperty("WarnThirdPartyPhaseout")
  WARN_THIRD_PARTY_PHASEOUT,
  @JsonProperty("WarnCrossSiteRedirectDowngradeChangesInclusion")
  WARN_CROSS_SITE_REDIRECT_DOWNGRADE_CHANGES_INCLUSION,
  @JsonProperty("WarnDeprecationTrialMetadata")
  WARN_DEPRECATION_TRIAL_METADATA,
  @JsonProperty("WarnThirdPartyCookieHeuristic")
  WARN_THIRD_PARTY_COOKIE_HEURISTIC,
  @JsonEnumDefaultValue
  UNKNOWN,
}
