package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.String

public data class LowTextContrastIssueDetails(
  @field:JsonProperty("violatingNodeId")
  public val violatingNodeId: Int,
  @field:JsonProperty("violatingNodeSelector")
  public val violatingNodeSelector: String,
  @field:JsonProperty("contrastRatio")
  public val contrastRatio: Double,
  @field:JsonProperty("thresholdAA")
  public val thresholdAA: Double,
  @field:JsonProperty("thresholdAAA")
  public val thresholdAAA: Double,
  @field:JsonProperty("fontSize")
  public val fontSize: String,
  @field:JsonProperty("fontWeight")
  public val fontWeight: String,
)
