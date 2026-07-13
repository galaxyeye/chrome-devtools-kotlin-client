@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * A unique identifier for the type of issue. Each type may use one of the
 * optional fields in InspectorIssueDetails to convey more specific
 * information about the kind of issue.
 */
public enum class InspectorIssueCode {
  @JsonProperty("CookieIssue")
  COOKIE_ISSUE,
  @JsonProperty("MixedContentIssue")
  MIXED_CONTENT_ISSUE,
  @JsonProperty("BlockedByResponseIssue")
  BLOCKED_BY_RESPONSE_ISSUE,
  @JsonProperty("HeavyAdIssue")
  HEAVY_AD_ISSUE,
  @JsonProperty("ContentSecurityPolicyIssue")
  CONTENT_SECURITY_POLICY_ISSUE,
  @JsonProperty("SharedArrayBufferIssue")
  SHARED_ARRAY_BUFFER_ISSUE,
  @JsonProperty("CorsIssue")
  CORS_ISSUE,
  @JsonProperty("AttributionReportingIssue")
  ATTRIBUTION_REPORTING_ISSUE,
  @JsonProperty("QuirksModeIssue")
  QUIRKS_MODE_ISSUE,
  @JsonProperty("PartitioningBlobURLIssue")
  PARTITIONING_BLOB_URL_ISSUE,
  @JsonProperty("NavigatorUserAgentIssue")
  NAVIGATOR_USER_AGENT_ISSUE,
  @JsonProperty("GenericIssue")
  GENERIC_ISSUE,
  @JsonProperty("DeprecationIssue")
  DEPRECATION_ISSUE,
  @JsonProperty("ClientHintIssue")
  CLIENT_HINT_ISSUE,
  @JsonProperty("FederatedAuthRequestIssue")
  FEDERATED_AUTH_REQUEST_ISSUE,
  @JsonProperty("BounceTrackingIssue")
  BOUNCE_TRACKING_ISSUE,
  @JsonProperty("CookieDeprecationMetadataIssue")
  COOKIE_DEPRECATION_METADATA_ISSUE,
  @JsonProperty("StylesheetLoadingIssue")
  STYLESHEET_LOADING_ISSUE,
  @JsonProperty("FederatedAuthUserInfoRequestIssue")
  FEDERATED_AUTH_USER_INFO_REQUEST_ISSUE,
  @JsonProperty("PropertyRuleIssue")
  PROPERTY_RULE_ISSUE,
  @JsonProperty("SharedDictionaryIssue")
  SHARED_DICTIONARY_ISSUE,
  @JsonProperty("ElementAccessibilityIssue")
  ELEMENT_ACCESSIBILITY_ISSUE,
  @JsonProperty("SRIMessageSignatureIssue")
  SRI_MESSAGE_SIGNATURE_ISSUE,
  @JsonProperty("UnencodedDigestIssue")
  UNENCODED_DIGEST_ISSUE,
  @JsonProperty("ConnectionAllowlistIssue")
  CONNECTION_ALLOWLIST_ISSUE,
  @JsonProperty("UserReidentificationIssue")
  USER_REIDENTIFICATION_ISSUE,
  @JsonProperty("PermissionElementIssue")
  PERMISSION_ELEMENT_ISSUE,
  @JsonProperty("PerformanceIssue")
  PERFORMANCE_ISSUE,
  @JsonProperty("SelectivePermissionsInterventionIssue")
  SELECTIVE_PERMISSIONS_INTERVENTION_ISSUE,
  @JsonProperty("EmailVerificationRequestIssue")
  EMAIL_VERIFICATION_REQUEST_ISSUE,
  @JsonEnumDefaultValue
  UNKNOWN,
}
