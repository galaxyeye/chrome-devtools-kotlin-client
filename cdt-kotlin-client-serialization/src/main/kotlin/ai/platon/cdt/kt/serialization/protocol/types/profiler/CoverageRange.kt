@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.profiler

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Coverage data for a source range.
 */
@Serializable
data class CoverageRange(
  @property:SerialName("startOffset")
  val startOffset: Int,
  @property:SerialName("endOffset")
  val endOffset: Int,
  @property:SerialName("count")
  val count: Int,
)
