@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Types of reasons why a cookie may not be stored from a response.
 */
@Serializable
public enum class SetCookieBlockedReason {
  @SerialName("SecureOnly")
  SECURE_ONLY,
  @SerialName("SameSiteStrict")
  SAME_SITE_STRICT,
  @SerialName("SameSiteLax")
  SAME_SITE_LAX,
  @SerialName("SameSiteUnspecifiedTreatedAsLax")
  SAME_SITE_UNSPECIFIED_TREATED_AS_LAX,
  @SerialName("SameSiteNoneInsecure")
  SAME_SITE_NONE_INSECURE,
  @SerialName("UserPreferences")
  USER_PREFERENCES,
  @SerialName("SyntaxError")
  SYNTAX_ERROR,
  @SerialName("SchemeNotSupported")
  SCHEME_NOT_SUPPORTED,
  @SerialName("OverwriteSecure")
  OVERWRITE_SECURE,
  @SerialName("InvalidDomain")
  INVALID_DOMAIN,
  @SerialName("InvalidPrefix")
  INVALID_PREFIX,
  @SerialName("UnknownError")
  UNKNOWN_ERROR,
  @SerialName("SchemefulSameSiteStrict")
  SCHEMEFUL_SAME_SITE_STRICT,
  @SerialName("SchemefulSameSiteLax")
  SCHEMEFUL_SAME_SITE_LAX,
  @SerialName("SchemefulSameSiteUnspecifiedTreatedAsLax")
  SCHEMEFUL_SAME_SITE_UNSPECIFIED_TREATED_AS_LAX,
  @SerialName("SamePartyFromCrossPartyContext")
  SAME_PARTY_FROM_CROSS_PARTY_CONTEXT,
  @SerialName("SamePartyConflictsWithOtherAttributes")
  SAME_PARTY_CONFLICTS_WITH_OTHER_ATTRIBUTES,
}
