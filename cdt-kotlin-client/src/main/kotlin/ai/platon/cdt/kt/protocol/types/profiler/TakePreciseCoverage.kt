package ai.platon.cdt.kt.protocol.types.profiler

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.collections.List

data class TakePreciseCoverage(
  @field:JsonProperty("result")
  val result: List<ScriptCoverage>,
  @field:JsonProperty("timestamp")
  val timestamp: Double,
)
