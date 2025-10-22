package ai.platon.cdt.kt.protocol.types.profiler

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Coverage data for a source range.
 */
data class CoverageRange(
  @field:JsonProperty("startOffset")
  val startOffset: Int,
  @field:JsonProperty("endOffset")
  val endOffset: Int,
  @field:JsonProperty("count")
  val count: Int,
)
