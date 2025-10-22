package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonProperty

public data class HeavyAdIssueDetails(
  @field:JsonProperty("resolution")
  public val resolution: HeavyAdResolutionStatus,
  @field:JsonProperty("reason")
  public val reason: HeavyAdReason,
  @field:JsonProperty("frame")
  public val frame: AffectedFrame,
)
