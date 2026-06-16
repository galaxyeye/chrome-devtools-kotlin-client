@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Represents the failure reason when a federated authentication reason fails.
 * Should be updated alongside RequestIdTokenStatus in
 * third_party/blink/public/mojom/devtools/inspector_issue.mojom to include
 * all cases except for success.
 */
public enum class FederatedAuthRequestIssueReason {
  @JsonProperty("ShouldEmbargo")
  SHOULD_EMBARGO,
  @JsonProperty("TooManyRequests")
  TOO_MANY_REQUESTS,
  @JsonProperty("WellKnownHttpNotFound")
  WELL_KNOWN_HTTP_NOT_FOUND,
  @JsonProperty("WellKnownNoResponse")
  WELL_KNOWN_NO_RESPONSE,
  @JsonProperty("WellKnownInvalidResponse")
  WELL_KNOWN_INVALID_RESPONSE,
  @JsonProperty("WellKnownListEmpty")
  WELL_KNOWN_LIST_EMPTY,
  @JsonProperty("WellKnownInvalidContentType")
  WELL_KNOWN_INVALID_CONTENT_TYPE,
  @JsonProperty("ConfigNotInWellKnown")
  CONFIG_NOT_IN_WELL_KNOWN,
  @JsonProperty("WellKnownTooBig")
  WELL_KNOWN_TOO_BIG,
  @JsonProperty("ConfigHttpNotFound")
  CONFIG_HTTP_NOT_FOUND,
  @JsonProperty("ConfigNoResponse")
  CONFIG_NO_RESPONSE,
  @JsonProperty("ConfigInvalidResponse")
  CONFIG_INVALID_RESPONSE,
  @JsonProperty("ConfigInvalidContentType")
  CONFIG_INVALID_CONTENT_TYPE,
  @JsonProperty("IdpNotPotentiallyTrustworthy")
  IDP_NOT_POTENTIALLY_TRUSTWORTHY,
  @JsonProperty("DisabledInSettings")
  DISABLED_IN_SETTINGS,
  @JsonProperty("DisabledInFlags")
  DISABLED_IN_FLAGS,
  @JsonProperty("ErrorFetchingSignin")
  ERROR_FETCHING_SIGNIN,
  @JsonProperty("InvalidSigninResponse")
  INVALID_SIGNIN_RESPONSE,
  @JsonProperty("AccountsHttpNotFound")
  ACCOUNTS_HTTP_NOT_FOUND,
  @JsonProperty("AccountsNoResponse")
  ACCOUNTS_NO_RESPONSE,
  @JsonProperty("AccountsInvalidResponse")
  ACCOUNTS_INVALID_RESPONSE,
  @JsonProperty("AccountsListEmpty")
  ACCOUNTS_LIST_EMPTY,
  @JsonProperty("AccountsInvalidContentType")
  ACCOUNTS_INVALID_CONTENT_TYPE,
  @JsonProperty("IdTokenHttpNotFound")
  ID_TOKEN_HTTP_NOT_FOUND,
  @JsonProperty("IdTokenNoResponse")
  ID_TOKEN_NO_RESPONSE,
  @JsonProperty("IdTokenInvalidResponse")
  ID_TOKEN_INVALID_RESPONSE,
  @JsonProperty("IdTokenIdpErrorResponse")
  ID_TOKEN_IDP_ERROR_RESPONSE,
  @JsonProperty("IdTokenCrossSiteIdpErrorResponse")
  ID_TOKEN_CROSS_SITE_IDP_ERROR_RESPONSE,
  @JsonProperty("IdTokenInvalidRequest")
  ID_TOKEN_INVALID_REQUEST,
  @JsonProperty("IdTokenInvalidContentType")
  ID_TOKEN_INVALID_CONTENT_TYPE,
  @JsonProperty("ErrorIdToken")
  ERROR_ID_TOKEN,
  @JsonProperty("Canceled")
  CANCELED,
  @JsonProperty("RpPageNotVisible")
  RP_PAGE_NOT_VISIBLE,
  @JsonProperty("SilentMediationFailure")
  SILENT_MEDIATION_FAILURE,
  @JsonProperty("NotSignedInWithIdp")
  NOT_SIGNED_IN_WITH_IDP,
  @JsonProperty("MissingTransientUserActivation")
  MISSING_TRANSIENT_USER_ACTIVATION,
  @JsonProperty("ReplacedByActiveMode")
  REPLACED_BY_ACTIVE_MODE,
  @JsonProperty("RelyingPartyOriginIsOpaque")
  RELYING_PARTY_ORIGIN_IS_OPAQUE,
  @JsonProperty("TypeNotMatching")
  TYPE_NOT_MATCHING,
  @JsonProperty("UiDismissedNoEmbargo")
  UI_DISMISSED_NO_EMBARGO,
  @JsonProperty("CorsError")
  CORS_ERROR,
  @JsonProperty("SuppressedBySegmentationPlatform")
  SUPPRESSED_BY_SEGMENTATION_PLATFORM,
  @JsonEnumDefaultValue
  UNKNOWN,
}
