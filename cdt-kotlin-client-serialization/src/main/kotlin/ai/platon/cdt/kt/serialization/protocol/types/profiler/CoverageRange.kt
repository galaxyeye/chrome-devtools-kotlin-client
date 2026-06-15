@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.profiler
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int

/**
 * Coverage data for a source range.
 */
@Serializable
data class CoverageRange(
  @SerialName("startOffset")
  val startOffset: Int,
  @SerialName("endOffset")
  val endOffset: Int,
  @SerialName("count")
  val count: Int,
)
