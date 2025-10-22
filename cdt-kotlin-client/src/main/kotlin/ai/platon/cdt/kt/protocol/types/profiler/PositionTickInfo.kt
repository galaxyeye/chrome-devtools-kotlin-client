package ai.platon.cdt.kt.protocol.types.profiler

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Specifies a number of samples attributed to a certain source position.
 */
public data class PositionTickInfo(
  @field:JsonProperty("line")
  public val line: Int,
  @field:JsonProperty("ticks")
  public val ticks: Int,
)
