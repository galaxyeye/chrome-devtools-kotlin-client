@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.heapprofiler

import kotlin.Double
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * If heap objects tracking has been started then backend regularly sends a current value for last
 * seen object id and corresponding timestamp. If the were changes in the heap since last event
 * then one or more heapStatsUpdate events will be sent before a new lastSeenObjectId event.
 */
@Serializable
data class LastSeenObjectId(
  @property:SerialName("lastSeenObjectId")
  val lastSeenObjectId: Int,
  @property:SerialName("timestamp")
  val timestamp: Double,
)
