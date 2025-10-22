package ai.platon.cdt.kt.protocol.types.profiler

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Coverage data for a source range.
 */
public data class CoverageRange(
  @field:JsonProperty("startOffset")
  public val startOffset: Int,
  @field:JsonProperty("endOffset")
  public val endOffset: Int,
  @field:JsonProperty("count")
  public val count: Int,
)
