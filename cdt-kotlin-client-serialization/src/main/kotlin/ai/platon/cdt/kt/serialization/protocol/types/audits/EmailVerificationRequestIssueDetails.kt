@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EmailVerificationRequestIssueDetails(
  @property:SerialName("emailVerificationRequestIssueReason")
  val emailVerificationRequestIssueReason: EmailVerificationRequestIssueReason,
)
