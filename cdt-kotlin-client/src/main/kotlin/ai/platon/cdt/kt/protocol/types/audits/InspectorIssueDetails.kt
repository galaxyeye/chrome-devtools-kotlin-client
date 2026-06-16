@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Deprecated

/**
 * This struct holds a list of optional fields with additional information
 * specific to the kind of issue. When adding a new issue code, please also
 * add a new optional field to this type.
 */
data class InspectorIssueDetails(
  @param:JsonProperty("cookieIssueDetails")
  @param:Optional
  val cookieIssueDetails: CookieIssueDetails? = null,
  @param:JsonProperty("mixedContentIssueDetails")
  @param:Optional
  val mixedContentIssueDetails: MixedContentIssueDetails? = null,
  @param:JsonProperty("blockedByResponseIssueDetails")
  @param:Optional
  val blockedByResponseIssueDetails: BlockedByResponseIssueDetails? = null,
  @param:JsonProperty("heavyAdIssueDetails")
  @param:Optional
  val heavyAdIssueDetails: HeavyAdIssueDetails? = null,
  @param:JsonProperty("contentSecurityPolicyIssueDetails")
  @param:Optional
  val contentSecurityPolicyIssueDetails: ContentSecurityPolicyIssueDetails? = null,
  @param:JsonProperty("sharedArrayBufferIssueDetails")
  @param:Optional
  val sharedArrayBufferIssueDetails: SharedArrayBufferIssueDetails? = null,
  @param:JsonProperty("corsIssueDetails")
  @param:Optional
  val corsIssueDetails: CorsIssueDetails? = null,
  @param:JsonProperty("attributionReportingIssueDetails")
  @param:Optional
  val attributionReportingIssueDetails: AttributionReportingIssueDetails? = null,
  @param:JsonProperty("quirksModeIssueDetails")
  @param:Optional
  val quirksModeIssueDetails: QuirksModeIssueDetails? = null,
  @param:JsonProperty("partitioningBlobURLIssueDetails")
  @param:Optional
  val partitioningBlobURLIssueDetails: PartitioningBlobURLIssueDetails? = null,
  @param:JsonProperty("navigatorUserAgentIssueDetails")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val navigatorUserAgentIssueDetails: NavigatorUserAgentIssueDetails? = null,
  @param:JsonProperty("genericIssueDetails")
  @param:Optional
  val genericIssueDetails: GenericIssueDetails? = null,
  @param:JsonProperty("deprecationIssueDetails")
  @param:Optional
  val deprecationIssueDetails: DeprecationIssueDetails? = null,
  @param:JsonProperty("clientHintIssueDetails")
  @param:Optional
  val clientHintIssueDetails: ClientHintIssueDetails? = null,
  @param:JsonProperty("federatedAuthRequestIssueDetails")
  @param:Optional
  val federatedAuthRequestIssueDetails: FederatedAuthRequestIssueDetails? = null,
  @param:JsonProperty("bounceTrackingIssueDetails")
  @param:Optional
  val bounceTrackingIssueDetails: BounceTrackingIssueDetails? = null,
  @param:JsonProperty("cookieDeprecationMetadataIssueDetails")
  @param:Optional
  val cookieDeprecationMetadataIssueDetails: CookieDeprecationMetadataIssueDetails? = null,
  @param:JsonProperty("stylesheetLoadingIssueDetails")
  @param:Optional
  val stylesheetLoadingIssueDetails: StylesheetLoadingIssueDetails? = null,
  @param:JsonProperty("propertyRuleIssueDetails")
  @param:Optional
  val propertyRuleIssueDetails: PropertyRuleIssueDetails? = null,
  @param:JsonProperty("federatedAuthUserInfoRequestIssueDetails")
  @param:Optional
  val federatedAuthUserInfoRequestIssueDetails:
      FederatedAuthUserInfoRequestIssueDetails? = null,
  @param:JsonProperty("sharedDictionaryIssueDetails")
  @param:Optional
  val sharedDictionaryIssueDetails: SharedDictionaryIssueDetails? = null,
  @param:JsonProperty("elementAccessibilityIssueDetails")
  @param:Optional
  val elementAccessibilityIssueDetails: ElementAccessibilityIssueDetails? = null,
  @param:JsonProperty("sriMessageSignatureIssueDetails")
  @param:Optional
  val sriMessageSignatureIssueDetails: SRIMessageSignatureIssueDetails? = null,
  @param:JsonProperty("unencodedDigestIssueDetails")
  @param:Optional
  val unencodedDigestIssueDetails: UnencodedDigestIssueDetails? = null,
  @param:JsonProperty("connectionAllowlistIssueDetails")
  @param:Optional
  val connectionAllowlistIssueDetails: ConnectionAllowlistIssueDetails? = null,
  @param:JsonProperty("userReidentificationIssueDetails")
  @param:Optional
  val userReidentificationIssueDetails: UserReidentificationIssueDetails? = null,
  @param:JsonProperty("permissionElementIssueDetails")
  @param:Optional
  val permissionElementIssueDetails: PermissionElementIssueDetails? = null,
  @param:JsonProperty("performanceIssueDetails")
  @param:Optional
  val performanceIssueDetails: PerformanceIssueDetails? = null,
  @param:JsonProperty("selectivePermissionsInterventionIssueDetails")
  @param:Optional
  val selectivePermissionsInterventionIssueDetails:
      SelectivePermissionsInterventionIssueDetails? = null,
  @param:JsonProperty("emailVerificationRequestIssueDetails")
  @param:Optional
  val emailVerificationRequestIssueDetails: EmailVerificationRequestIssueDetails? = null,
)
