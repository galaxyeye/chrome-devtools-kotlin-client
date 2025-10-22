package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * An inspector issue reported from the back-end.
 */
public data class InspectorIssue(
  @field:JsonProperty("code")
  public val code: InspectorIssueCode,
  @field:JsonProperty("details")
  public val details: InspectorIssueDetails,
)
