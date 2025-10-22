package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * This struct holds a list of optional fields with additional information
 * specific to the kind of issue. When adding a new issue code, please also
 * add a new optional field to this type.
 */
data class InspectorIssueDetails(
  @field:JsonProperty("sameSiteCookieIssueDetails")
  @param:Optional
  val sameSiteCookieIssueDetails: SameSiteCookieIssueDetails? = null,
  @field:JsonProperty("mixedContentIssueDetails")
  @param:Optional
  val mixedContentIssueDetails: MixedContentIssueDetails? = null,
  @field:JsonProperty("blockedByResponseIssueDetails")
  @param:Optional
  val blockedByResponseIssueDetails: BlockedByResponseIssueDetails? = null,
  @field:JsonProperty("heavyAdIssueDetails")
  @param:Optional
  val heavyAdIssueDetails: HeavyAdIssueDetails? = null,
  @field:JsonProperty("contentSecurityPolicyIssueDetails")
  @param:Optional
  val contentSecurityPolicyIssueDetails: ContentSecurityPolicyIssueDetails? = null,
  @field:JsonProperty("sharedArrayBufferIssueDetails")
  @param:Optional
  val sharedArrayBufferIssueDetails: SharedArrayBufferIssueDetails? = null,
  @field:JsonProperty("twaQualityEnforcementDetails")
  @param:Optional
  val twaQualityEnforcementDetails: TrustedWebActivityIssueDetails? = null,
  @field:JsonProperty("lowTextContrastIssueDetails")
  @param:Optional
  val lowTextContrastIssueDetails: LowTextContrastIssueDetails? = null,
  @field:JsonProperty("corsIssueDetails")
  @param:Optional
  val corsIssueDetails: CorsIssueDetails? = null,
  @field:JsonProperty("attributionReportingIssueDetails")
  @param:Optional
  val attributionReportingIssueDetails: AttributionReportingIssueDetails? = null,
)
