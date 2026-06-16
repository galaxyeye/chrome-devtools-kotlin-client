@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the failure reason when a federated authentication reason fails.
 * Should be updated alongside RequestIdTokenStatus in
 * third_party/blink/public/mojom/devtools/inspector_issue.mojom to include
 * all cases except for success.
 */
@Serializable
public enum class FederatedAuthRequestIssueReason {
  @SerialName("ShouldEmbargo")
  SHOULD_EMBARGO,
  @SerialName("TooManyRequests")
  TOO_MANY_REQUESTS,
  @SerialName("WellKnownHttpNotFound")
  WELL_KNOWN_HTTP_NOT_FOUND,
  @SerialName("WellKnownNoResponse")
  WELL_KNOWN_NO_RESPONSE,
  @SerialName("WellKnownInvalidResponse")
  WELL_KNOWN_INVALID_RESPONSE,
  @SerialName("WellKnownListEmpty")
  WELL_KNOWN_LIST_EMPTY,
  @SerialName("WellKnownInvalidContentType")
  WELL_KNOWN_INVALID_CONTENT_TYPE,
  @SerialName("ConfigNotInWellKnown")
  CONFIG_NOT_IN_WELL_KNOWN,
  @SerialName("WellKnownTooBig")
  WELL_KNOWN_TOO_BIG,
  @SerialName("ConfigHttpNotFound")
  CONFIG_HTTP_NOT_FOUND,
  @SerialName("ConfigNoResponse")
  CONFIG_NO_RESPONSE,
  @SerialName("ConfigInvalidResponse")
  CONFIG_INVALID_RESPONSE,
  @SerialName("ConfigInvalidContentType")
  CONFIG_INVALID_CONTENT_TYPE,
  @SerialName("IdpNotPotentiallyTrustworthy")
  IDP_NOT_POTENTIALLY_TRUSTWORTHY,
  @SerialName("DisabledInSettings")
  DISABLED_IN_SETTINGS,
  @SerialName("DisabledInFlags")
  DISABLED_IN_FLAGS,
  @SerialName("ErrorFetchingSignin")
  ERROR_FETCHING_SIGNIN,
  @SerialName("InvalidSigninResponse")
  INVALID_SIGNIN_RESPONSE,
  @SerialName("AccountsHttpNotFound")
  ACCOUNTS_HTTP_NOT_FOUND,
  @SerialName("AccountsNoResponse")
  ACCOUNTS_NO_RESPONSE,
  @SerialName("AccountsInvalidResponse")
  ACCOUNTS_INVALID_RESPONSE,
  @SerialName("AccountsListEmpty")
  ACCOUNTS_LIST_EMPTY,
  @SerialName("AccountsInvalidContentType")
  ACCOUNTS_INVALID_CONTENT_TYPE,
  @SerialName("IdTokenHttpNotFound")
  ID_TOKEN_HTTP_NOT_FOUND,
  @SerialName("IdTokenNoResponse")
  ID_TOKEN_NO_RESPONSE,
  @SerialName("IdTokenInvalidResponse")
  ID_TOKEN_INVALID_RESPONSE,
  @SerialName("IdTokenIdpErrorResponse")
  ID_TOKEN_IDP_ERROR_RESPONSE,
  @SerialName("IdTokenCrossSiteIdpErrorResponse")
  ID_TOKEN_CROSS_SITE_IDP_ERROR_RESPONSE,
  @SerialName("IdTokenInvalidRequest")
  ID_TOKEN_INVALID_REQUEST,
  @SerialName("IdTokenInvalidContentType")
  ID_TOKEN_INVALID_CONTENT_TYPE,
  @SerialName("ErrorIdToken")
  ERROR_ID_TOKEN,
  @SerialName("Canceled")
  CANCELED,
  @SerialName("RpPageNotVisible")
  RP_PAGE_NOT_VISIBLE,
  @SerialName("SilentMediationFailure")
  SILENT_MEDIATION_FAILURE,
  @SerialName("NotSignedInWithIdp")
  NOT_SIGNED_IN_WITH_IDP,
  @SerialName("MissingTransientUserActivation")
  MISSING_TRANSIENT_USER_ACTIVATION,
  @SerialName("ReplacedByActiveMode")
  REPLACED_BY_ACTIVE_MODE,
  @SerialName("RelyingPartyOriginIsOpaque")
  RELYING_PARTY_ORIGIN_IS_OPAQUE,
  @SerialName("TypeNotMatching")
  TYPE_NOT_MATCHING,
  @SerialName("UiDismissedNoEmbargo")
  UI_DISMISSED_NO_EMBARGO,
  @SerialName("CorsError")
  CORS_ERROR,
  @SerialName("SuppressedBySegmentationPlatform")
  SUPPRESSED_BY_SEGMENTATION_PLATFORM,
  UNKNOWN,
}
