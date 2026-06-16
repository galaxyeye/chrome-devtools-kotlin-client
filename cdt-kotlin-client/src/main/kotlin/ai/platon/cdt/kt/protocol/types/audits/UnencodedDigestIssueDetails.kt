@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonProperty

data class UnencodedDigestIssueDetails(
  @param:JsonProperty("error")
  val error: UnencodedDigestError,
  @param:JsonProperty("request")
  val request: AffectedRequest,
)
