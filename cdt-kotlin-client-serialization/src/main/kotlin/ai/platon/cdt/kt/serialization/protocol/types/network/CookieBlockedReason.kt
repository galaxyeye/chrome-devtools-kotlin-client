@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Types of reasons why a cookie may not be sent with a request.
 */
@Serializable
public enum class CookieBlockedReason {
  @SerialName("SecureOnly")
  SECURE_ONLY,
  @SerialName("NotOnPath")
  NOT_ON_PATH,
  @SerialName("DomainMismatch")
  DOMAIN_MISMATCH,
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
}
