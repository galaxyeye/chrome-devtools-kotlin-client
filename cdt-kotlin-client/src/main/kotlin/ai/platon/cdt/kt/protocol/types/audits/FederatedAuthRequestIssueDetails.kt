@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonProperty

data class FederatedAuthRequestIssueDetails(
  @param:JsonProperty("federatedAuthRequestIssueReason")
  val federatedAuthRequestIssueReason: FederatedAuthRequestIssueReason,
)
