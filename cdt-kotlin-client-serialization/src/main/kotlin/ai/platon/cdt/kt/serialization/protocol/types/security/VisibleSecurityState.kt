@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.security
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List

/**
 * Security state information about the page.
 */
@Experimental
@Serializable
data class VisibleSecurityState(
  @SerialName("securityState")
  val securityState: SecurityState,
  @SerialName("certificateSecurityState")
  @param:Optional
  val certificateSecurityState: CertificateSecurityState? = null,
  @SerialName("safetyTipInfo")
  @param:Optional
  val safetyTipInfo: SafetyTipInfo? = null,
  @SerialName("securityStateIssueIds")
  val securityStateIssueIds: List<String>,
)
