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
  @SerialName("SameSiteCookieIssue")
  SAME_SITE_COOKIE_ISSUE,
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
  @SerialName("TrustedWebActivityIssue")
  TRUSTED_WEB_ACTIVITY_ISSUE,
  @SerialName("LowTextContrastIssue")
  LOW_TEXT_CONTRAST_ISSUE,
  @SerialName("CorsIssue")
  CORS_ISSUE,
  @SerialName("AttributionReportingIssue")
  ATTRIBUTION_REPORTING_ISSUE,
}
