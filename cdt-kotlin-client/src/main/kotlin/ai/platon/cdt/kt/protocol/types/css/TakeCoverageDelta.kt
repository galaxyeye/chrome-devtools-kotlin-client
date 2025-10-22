package ai.platon.cdt.kt.protocol.types.css

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.collections.List

data class TakeCoverageDelta(
  @field:JsonProperty("coverage")
  val coverage: List<RuleUsage>,
  @field:JsonProperty("timestamp")
  val timestamp: Double,
)
