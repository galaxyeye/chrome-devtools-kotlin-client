@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.profiler
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String
import kotlin.collections.List

/**
 * Coverage data for a JavaScript script.
 */
@Serializable
data class ScriptCoverage(
  @SerialName("scriptId")
  val scriptId: String,
  @SerialName("url")
  val url: String,
  @SerialName("functions")
  val functions: List<FunctionCoverage>,
)
