@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.profiler
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

/**
 * Coverage data for a JavaScript function.
 */
@Serializable
data class FunctionCoverage(
  @SerialName("functionName")
  val functionName: String,
  @SerialName("ranges")
  val ranges: List<CoverageRange>,
  @SerialName("isBlockCoverage")
  val isBlockCoverage: Boolean,
)
