@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This struct holds a list of optional fields with additional information
 * specific to the kind of issue. When adding a new issue code, please also
 * add a new optional field to this type.
 */
@Serializable
data class InspectorIssueDetails(
  @property:SerialName("sameSiteCookieIssueDetails")
  @param:Optional
  val sameSiteCookieIssueDetails: SameSiteCookieIssueDetails? = null,
  @property:SerialName("mixedContentIssueDetails")
  @param:Optional
  val mixedContentIssueDetails: MixedContentIssueDetails? = null,
  @property:SerialName("blockedByResponseIssueDetails")
  @param:Optional
  val blockedByResponseIssueDetails: BlockedByResponseIssueDetails? = null,
  @property:SerialName("heavyAdIssueDetails")
  @param:Optional
  val heavyAdIssueDetails: HeavyAdIssueDetails? = null,
  @property:SerialName("contentSecurityPolicyIssueDetails")
  @param:Optional
  val contentSecurityPolicyIssueDetails: ContentSecurityPolicyIssueDetails? = null,
  @property:SerialName("sharedArrayBufferIssueDetails")
  @param:Optional
  val sharedArrayBufferIssueDetails: SharedArrayBufferIssueDetails? = null,
  @property:SerialName("twaQualityEnforcementDetails")
  @param:Optional
  val twaQualityEnforcementDetails: TrustedWebActivityIssueDetails? = null,
  @property:SerialName("lowTextContrastIssueDetails")
  @param:Optional
  val lowTextContrastIssueDetails: LowTextContrastIssueDetails? = null,
  @property:SerialName("corsIssueDetails")
  @param:Optional
  val corsIssueDetails: CorsIssueDetails? = null,
  @property:SerialName("attributionReportingIssueDetails")
  @param:Optional
  val attributionReportingIssueDetails: AttributionReportingIssueDetails? = null,
)
