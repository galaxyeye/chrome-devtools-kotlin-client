package ai.platon.cdt.kt.protocol.types.profiler

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Specifies a number of samples attributed to a certain source position.
 */
data class PositionTickInfo(
  @field:JsonProperty("line")
  val line: Int,
  @field:JsonProperty("ticks")
  val ticks: Int,
)
