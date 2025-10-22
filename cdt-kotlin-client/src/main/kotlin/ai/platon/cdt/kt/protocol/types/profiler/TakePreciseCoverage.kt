package ai.platon.cdt.kt.protocol.types.profiler

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.collections.List

public data class TakePreciseCoverage(
  @field:JsonProperty("result")
  public val result: List<ScriptCoverage>,
  @field:JsonProperty("timestamp")
  public val timestamp: Double,
)
