@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FederatedAuthRequestIssueDetails(
  @property:SerialName("federatedAuthRequestIssueReason")
  val federatedAuthRequestIssueReason: FederatedAuthRequestIssueReason,
)
