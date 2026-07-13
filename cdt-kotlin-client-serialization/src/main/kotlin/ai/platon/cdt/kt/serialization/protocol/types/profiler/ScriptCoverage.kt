@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.profiler

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Coverage data for a JavaScript script.
 */
@Serializable
data class ScriptCoverage(
  @property:SerialName("scriptId")
  val scriptId: String,
  @property:SerialName("url")
  val url: String,
  @property:SerialName("functions")
  val functions: List<FunctionCoverage>,
)
