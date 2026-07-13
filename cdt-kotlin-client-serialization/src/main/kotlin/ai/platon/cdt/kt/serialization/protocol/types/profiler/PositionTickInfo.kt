@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.profiler

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Specifies a number of samples attributed to a certain source position.
 */
@Serializable
data class PositionTickInfo(
  @property:SerialName("line")
  val line: Int,
  @property:SerialName("ticks")
  val ticks: Int,
)
