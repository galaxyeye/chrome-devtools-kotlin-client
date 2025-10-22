package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * This struct holds a list of optional fields with additional information
 * specific to the kind of issue. When adding a new issue code, please also
 * add a new optional field to this type.
 */
public data class InspectorIssueDetails(
  @field:JsonProperty("sameSiteCookieIssueDetails")
  @param:Optional
  public val sameSiteCookieIssueDetails: SameSiteCookieIssueDetails? = null,
  @field:JsonProperty("mixedContentIssueDetails")
  @param:Optional
  public val mixedContentIssueDetails: MixedContentIssueDetails? = null,
  @field:JsonProperty("blockedByResponseIssueDetails")
  @param:Optional
  public val blockedByResponseIssueDetails: BlockedByResponseIssueDetails? = null,
  @field:JsonProperty("heavyAdIssueDetails")
  @param:Optional
  public val heavyAdIssueDetails: HeavyAdIssueDetails? = null,
  @field:JsonProperty("contentSecurityPolicyIssueDetails")
  @param:Optional
  public val contentSecurityPolicyIssueDetails: ContentSecurityPolicyIssueDetails? = null,
  @field:JsonProperty("sharedArrayBufferIssueDetails")
  @param:Optional
  public val sharedArrayBufferIssueDetails: SharedArrayBufferIssueDetails? = null,
  @field:JsonProperty("twaQualityEnforcementDetails")
  @param:Optional
  public val twaQualityEnforcementDetails: TrustedWebActivityIssueDetails? = null,
  @field:JsonProperty("lowTextContrastIssueDetails")
  @param:Optional
  public val lowTextContrastIssueDetails: LowTextContrastIssueDetails? = null,
  @field:JsonProperty("corsIssueDetails")
  @param:Optional
  public val corsIssueDetails: CorsIssueDetails? = null,
  @field:JsonProperty("attributionReportingIssueDetails")
  @param:Optional
  public val attributionReportingIssueDetails: AttributionReportingIssueDetails? = null,
)
