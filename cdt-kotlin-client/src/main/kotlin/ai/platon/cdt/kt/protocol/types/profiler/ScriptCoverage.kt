package ai.platon.cdt.kt.protocol.types.profiler

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * Coverage data for a JavaScript script.
 */
public data class ScriptCoverage(
  @field:JsonProperty("scriptId")
  public val scriptId: String,
  @field:JsonProperty("url")
  public val url: String,
  @field:JsonProperty("functions")
  public val functions: List<FunctionCoverage>,
)
