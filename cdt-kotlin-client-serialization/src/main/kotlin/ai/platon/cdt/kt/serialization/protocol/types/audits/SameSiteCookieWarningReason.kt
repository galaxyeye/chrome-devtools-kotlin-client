@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class SameSiteCookieWarningReason {
  @SerialName("WarnSameSiteUnspecifiedCrossSiteContext")
  WARN_SAME_SITE_UNSPECIFIED_CROSS_SITE_CONTEXT,
  @SerialName("WarnSameSiteNoneInsecure")
  WARN_SAME_SITE_NONE_INSECURE,
  @SerialName("WarnSameSiteUnspecifiedLaxAllowUnsafe")
  WARN_SAME_SITE_UNSPECIFIED_LAX_ALLOW_UNSAFE,
  @SerialName("WarnSameSiteStrictLaxDowngradeStrict")
  WARN_SAME_SITE_STRICT_LAX_DOWNGRADE_STRICT,
  @SerialName("WarnSameSiteStrictCrossDowngradeStrict")
  WARN_SAME_SITE_STRICT_CROSS_DOWNGRADE_STRICT,
  @SerialName("WarnSameSiteStrictCrossDowngradeLax")
  WARN_SAME_SITE_STRICT_CROSS_DOWNGRADE_LAX,
  @SerialName("WarnSameSiteLaxCrossDowngradeStrict")
  WARN_SAME_SITE_LAX_CROSS_DOWNGRADE_STRICT,
  @SerialName("WarnSameSiteLaxCrossDowngradeLax")
  WARN_SAME_SITE_LAX_CROSS_DOWNGRADE_LAX,
  UNKNOWN,
}
