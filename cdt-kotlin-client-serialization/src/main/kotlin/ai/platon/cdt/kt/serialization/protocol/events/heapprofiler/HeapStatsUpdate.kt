@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.heapprofiler
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int
import kotlin.collections.List

/**
 * If heap objects tracking has been started then backend may send update for one or more fragments
 */
@Serializable
data class HeapStatsUpdate(
  @SerialName("statsUpdate")
  val statsUpdate: List<Int>,
)
