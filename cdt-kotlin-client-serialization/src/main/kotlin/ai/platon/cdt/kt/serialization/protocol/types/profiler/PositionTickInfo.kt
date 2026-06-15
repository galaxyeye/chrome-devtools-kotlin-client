@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.profiler
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int

/**
 * Specifies a number of samples attributed to a certain source position.
 */
@Serializable
data class PositionTickInfo(
  @SerialName("line")
  val line: Int,
  @SerialName("ticks")
  val ticks: Int,
)
