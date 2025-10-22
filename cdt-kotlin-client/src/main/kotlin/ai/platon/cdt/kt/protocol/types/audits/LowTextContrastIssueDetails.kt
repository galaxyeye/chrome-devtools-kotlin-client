package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.String

data class LowTextContrastIssueDetails(
  @field:JsonProperty("violatingNodeId")
  val violatingNodeId: Int,
  @field:JsonProperty("violatingNodeSelector")
  val violatingNodeSelector: String,
  @field:JsonProperty("contrastRatio")
  val contrastRatio: Double,
  @field:JsonProperty("thresholdAA")
  val thresholdAA: Double,
  @field:JsonProperty("thresholdAAA")
  val thresholdAAA: Double,
  @field:JsonProperty("fontSize")
  val fontSize: String,
  @field:JsonProperty("fontWeight")
  val fontWeight: String,
)
