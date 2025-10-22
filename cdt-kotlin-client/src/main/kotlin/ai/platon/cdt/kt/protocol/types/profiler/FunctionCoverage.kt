package ai.platon.cdt.kt.protocol.types.profiler

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

/**
 * Coverage data for a JavaScript function.
 */
data class FunctionCoverage(
  @field:JsonProperty("functionName")
  val functionName: String,
  @field:JsonProperty("ranges")
  val ranges: List<CoverageRange>,
  @field:JsonProperty("isBlockCoverage")
  val isBlockCoverage: Boolean,
)
