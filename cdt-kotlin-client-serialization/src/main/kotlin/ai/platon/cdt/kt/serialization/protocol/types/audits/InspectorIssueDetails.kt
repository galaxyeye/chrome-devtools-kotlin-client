@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Deprecated
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This struct holds a list of optional fields with additional information
 * specific to the kind of issue. When adding a new issue code, please also
 * add a new optional field to this type.
 */
@Serializable
data class InspectorIssueDetails(
  @property:SerialName("cookieIssueDetails")
  @param:Optional
  val cookieIssueDetails: CookieIssueDetails? = null,
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
  @property:SerialName("corsIssueDetails")
  @param:Optional
  val corsIssueDetails: CorsIssueDetails? = null,
  @property:SerialName("attributionReportingIssueDetails")
  @param:Optional
  val attributionReportingIssueDetails: AttributionReportingIssueDetails? = null,
  @property:SerialName("quirksModeIssueDetails")
  @param:Optional
  val quirksModeIssueDetails: QuirksModeIssueDetails? = null,
  @property:SerialName("partitioningBlobURLIssueDetails")
  @param:Optional
  val partitioningBlobURLIssueDetails: PartitioningBlobURLIssueDetails? = null,
  @property:SerialName("navigatorUserAgentIssueDetails")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val navigatorUserAgentIssueDetails: NavigatorUserAgentIssueDetails? = null,
  @property:SerialName("genericIssueDetails")
  @param:Optional
  val genericIssueDetails: GenericIssueDetails? = null,
  @property:SerialName("deprecationIssueDetails")
  @param:Optional
  val deprecationIssueDetails: DeprecationIssueDetails? = null,
  @property:SerialName("clientHintIssueDetails")
  @param:Optional
  val clientHintIssueDetails: ClientHintIssueDetails? = null,
  @property:SerialName("federatedAuthRequestIssueDetails")
  @param:Optional
  val federatedAuthRequestIssueDetails: FederatedAuthRequestIssueDetails? = null,
  @property:SerialName("bounceTrackingIssueDetails")
  @param:Optional
  val bounceTrackingIssueDetails: BounceTrackingIssueDetails? = null,
  @property:SerialName("cookieDeprecationMetadataIssueDetails")
  @param:Optional
  val cookieDeprecationMetadataIssueDetails: CookieDeprecationMetadataIssueDetails? = null,
  @property:SerialName("stylesheetLoadingIssueDetails")
  @param:Optional
  val stylesheetLoadingIssueDetails: StylesheetLoadingIssueDetails? = null,
  @property:SerialName("propertyRuleIssueDetails")
  @param:Optional
  val propertyRuleIssueDetails: PropertyRuleIssueDetails? = null,
  @property:SerialName("federatedAuthUserInfoRequestIssueDetails")
  @param:Optional
  val federatedAuthUserInfoRequestIssueDetails:
      FederatedAuthUserInfoRequestIssueDetails? = null,
  @property:SerialName("sharedDictionaryIssueDetails")
  @param:Optional
  val sharedDictionaryIssueDetails: SharedDictionaryIssueDetails? = null,
  @property:SerialName("elementAccessibilityIssueDetails")
  @param:Optional
  val elementAccessibilityIssueDetails: ElementAccessibilityIssueDetails? = null,
  @property:SerialName("sriMessageSignatureIssueDetails")
  @param:Optional
  val sriMessageSignatureIssueDetails: SRIMessageSignatureIssueDetails? = null,
  @property:SerialName("unencodedDigestIssueDetails")
  @param:Optional
  val unencodedDigestIssueDetails: UnencodedDigestIssueDetails? = null,
  @property:SerialName("connectionAllowlistIssueDetails")
  @param:Optional
  val connectionAllowlistIssueDetails: ConnectionAllowlistIssueDetails? = null,
  @property:SerialName("userReidentificationIssueDetails")
  @param:Optional
  val userReidentificationIssueDetails: UserReidentificationIssueDetails? = null,
  @property:SerialName("permissionElementIssueDetails")
  @param:Optional
  val permissionElementIssueDetails: PermissionElementIssueDetails? = null,
  @property:SerialName("performanceIssueDetails")
  @param:Optional
  val performanceIssueDetails: PerformanceIssueDetails? = null,
  @property:SerialName("selectivePermissionsInterventionIssueDetails")
  @param:Optional
  val selectivePermissionsInterventionIssueDetails:
      SelectivePermissionsInterventionIssueDetails? = null,
  @property:SerialName("emailVerificationRequestIssueDetails")
  @param:Optional
  val emailVerificationRequestIssueDetails: EmailVerificationRequestIssueDetails? = null,
)
