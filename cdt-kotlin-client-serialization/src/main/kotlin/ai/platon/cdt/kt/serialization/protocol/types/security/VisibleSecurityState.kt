@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.security

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Security state information about the page.
 */
@Serializable
@Experimental
data class VisibleSecurityState(
  @property:SerialName("securityState")
  val securityState: SecurityState,
  @property:SerialName("certificateSecurityState")
  @param:Optional
  val certificateSecurityState: CertificateSecurityState? = null,
  @property:SerialName("safetyTipInfo")
  @param:Optional
  val safetyTipInfo: SafetyTipInfo? = null,
  @property:SerialName("securityStateIssueIds")
  val securityStateIssueIds: List<String>,
)
