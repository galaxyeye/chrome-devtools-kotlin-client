package ai.platon.cdt.kt.protocol.events.audits

import ai.platon.cdt.kt.protocol.types.audits.InspectorIssue
import com.fasterxml.jackson.`annotation`.JsonProperty

data class IssueAdded(
  @field:JsonProperty("issue")
  val issue: InspectorIssue,
)
