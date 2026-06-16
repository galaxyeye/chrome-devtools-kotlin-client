@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.profiler

import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Coverage data for a JavaScript function.
 */
@Serializable
data class FunctionCoverage(
  @property:SerialName("functionName")
  val functionName: String,
  @property:SerialName("ranges")
  val ranges: List<CoverageRange>,
  @property:SerialName("isBlockCoverage")
  val isBlockCoverage: Boolean,
)
