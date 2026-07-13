@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonProperty

data class ConnectionAllowlistIssueDetails(
  @param:JsonProperty("error")
  val error: ConnectionAllowlistError,
  @param:JsonProperty("request")
  val request: AffectedRequest,
)
