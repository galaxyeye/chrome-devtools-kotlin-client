package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * An inspector issue reported from the back-end.
 */
data class InspectorIssue(
  @field:JsonProperty("code")
  val code: InspectorIssueCode,
  @field:JsonProperty("details")
  val details: InspectorIssueDetails,
)
