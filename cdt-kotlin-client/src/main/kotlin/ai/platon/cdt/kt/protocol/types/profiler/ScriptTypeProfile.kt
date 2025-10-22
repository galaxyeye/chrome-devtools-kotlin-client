package ai.platon.cdt.kt.protocol.types.profiler

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * Type profile data collected during runtime for a JavaScript script.
 */
@Experimental
data class ScriptTypeProfile(
  @field:JsonProperty("scriptId")
  val scriptId: String,
  @field:JsonProperty("url")
  val url: String,
  @field:JsonProperty("entries")
  val entries: List<TypeProfileEntry>,
)
