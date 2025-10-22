package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonProperty

data class HeavyAdIssueDetails(
  @field:JsonProperty("resolution")
  val resolution: HeavyAdResolutionStatus,
  @field:JsonProperty("reason")
  val reason: HeavyAdReason,
  @field:JsonProperty("frame")
  val frame: AffectedFrame,
)
