@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A unique identifier for the type of issue. Each type may use one of the
 * optional fields in InspectorIssueDetails to convey more specific
 * information about the kind of issue.
 */
@Serializable
public enum class InspectorIssueCode {
  @SerialName("CookieIssue")
  COOKIE_ISSUE,
  @SerialName("MixedContentIssue")
  MIXED_CONTENT_ISSUE,
  @SerialName("BlockedByResponseIssue")
  BLOCKED_BY_RESPONSE_ISSUE,
  @SerialName("HeavyAdIssue")
  HEAVY_AD_ISSUE,
  @SerialName("ContentSecurityPolicyIssue")
  CONTENT_SECURITY_POLICY_ISSUE,
  @SerialName("SharedArrayBufferIssue")
  SHARED_ARRAY_BUFFER_ISSUE,
  @SerialName("CorsIssue")
  CORS_ISSUE,
  @SerialName("AttributionReportingIssue")
  ATTRIBUTION_REPORTING_ISSUE,
  @SerialName("QuirksModeIssue")
  QUIRKS_MODE_ISSUE,
  @SerialName("PartitioningBlobURLIssue")
  PARTITIONING_BLOB_URL_ISSUE,
  @SerialName("NavigatorUserAgentIssue")
  NAVIGATOR_USER_AGENT_ISSUE,
  @SerialName("GenericIssue")
  GENERIC_ISSUE,
  @SerialName("DeprecationIssue")
  DEPRECATION_ISSUE,
  @SerialName("ClientHintIssue")
  CLIENT_HINT_ISSUE,
  @SerialName("FederatedAuthRequestIssue")
  FEDERATED_AUTH_REQUEST_ISSUE,
  @SerialName("BounceTrackingIssue")
  BOUNCE_TRACKING_ISSUE,
  @SerialName("CookieDeprecationMetadataIssue")
  COOKIE_DEPRECATION_METADATA_ISSUE,
  @SerialName("StylesheetLoadingIssue")
  STYLESHEET_LOADING_ISSUE,
  @SerialName("FederatedAuthUserInfoRequestIssue")
  FEDERATED_AUTH_USER_INFO_REQUEST_ISSUE,
  @SerialName("PropertyRuleIssue")
  PROPERTY_RULE_ISSUE,
  @SerialName("SharedDictionaryIssue")
  SHARED_DICTIONARY_ISSUE,
  @SerialName("ElementAccessibilityIssue")
  ELEMENT_ACCESSIBILITY_ISSUE,
  @SerialName("SRIMessageSignatureIssue")
  SRI_MESSAGE_SIGNATURE_ISSUE,
  @SerialName("UnencodedDigestIssue")
  UNENCODED_DIGEST_ISSUE,
  @SerialName("ConnectionAllowlistIssue")
  CONNECTION_ALLOWLIST_ISSUE,
  @SerialName("UserReidentificationIssue")
  USER_REIDENTIFICATION_ISSUE,
  @SerialName("PermissionElementIssue")
  PERMISSION_ELEMENT_ISSUE,
  @SerialName("PerformanceIssue")
  PERFORMANCE_ISSUE,
  @SerialName("SelectivePermissionsInterventionIssue")
  SELECTIVE_PERMISSIONS_INTERVENTION_ISSUE,
  @SerialName("EmailVerificationRequestIssue")
  EMAIL_VERIFICATION_REQUEST_ISSUE,
  UNKNOWN,
}
