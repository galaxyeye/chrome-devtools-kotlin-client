package ai.platon.cdt.kt.protocol.types.profiler

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * Coverage data for a JavaScript script.
 */
data class ScriptCoverage(
  @field:JsonProperty("scriptId")
  val scriptId: String,
  @field:JsonProperty("url")
  val url: String,
  @field:JsonProperty("functions")
  val functions: List<FunctionCoverage>,
)
