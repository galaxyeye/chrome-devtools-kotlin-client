@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional

/**
 * This struct holds a list of optional fields with additional information
 * specific to the kind of issue. When adding a new issue code, please also
 * add a new optional field to this type.
 */
@Serializable
data class InspectorIssueDetails(
  @SerialName("sameSiteCookieIssueDetails")
  @param:Optional
  val sameSiteCookieIssueDetails: SameSiteCookieIssueDetails? = null,
  @SerialName("mixedContentIssueDetails")
  @param:Optional
  val mixedContentIssueDetails: MixedContentIssueDetails? = null,
  @SerialName("blockedByResponseIssueDetails")
  @param:Optional
  val blockedByResponseIssueDetails: BlockedByResponseIssueDetails? = null,
  @SerialName("heavyAdIssueDetails")
  @param:Optional
  val heavyAdIssueDetails: HeavyAdIssueDetails? = null,
  @SerialName("contentSecurityPolicyIssueDetails")
  @param:Optional
  val contentSecurityPolicyIssueDetails: ContentSecurityPolicyIssueDetails? = null,
  @SerialName("sharedArrayBufferIssueDetails")
  @param:Optional
  val sharedArrayBufferIssueDetails: SharedArrayBufferIssueDetails? = null,
  @SerialName("twaQualityEnforcementDetails")
  @param:Optional
  val twaQualityEnforcementDetails: TrustedWebActivityIssueDetails? = null,
  @SerialName("lowTextContrastIssueDetails")
  @param:Optional
  val lowTextContrastIssueDetails: LowTextContrastIssueDetails? = null,
  @SerialName("corsIssueDetails")
  @param:Optional
  val corsIssueDetails: CorsIssueDetails? = null,
  @SerialName("attributionReportingIssueDetails")
  @param:Optional
  val attributionReportingIssueDetails: AttributionReportingIssueDetails? = null,
)
