@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.heapprofiler

import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * If heap objects tracking has been started then backend may send update for one or more fragments
 */
@Serializable
data class HeapStatsUpdate(
  @property:SerialName("statsUpdate")
  val statsUpdate: List<Int>,
)
