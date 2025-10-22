package ai.platon.cdt.kt.protocol.types.profiler

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

/**
 * Coverage data for a JavaScript function.
 */
public data class FunctionCoverage(
  @field:JsonProperty("functionName")
  public val functionName: String,
  @field:JsonProperty("ranges")
  public val ranges: List<CoverageRange>,
  @field:JsonProperty("isBlockCoverage")
  public val isBlockCoverage: Boolean,
)
