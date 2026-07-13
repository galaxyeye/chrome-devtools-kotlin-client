@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.media

import ai.platon.cdt.kt.serialization.protocol.types.media.PlayerEvent
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Send events as a list, allowing them to be batched on the browser for less
 * congestion. If batched, events must ALWAYS be in chronological order.
 */
@Serializable
data class PlayerEventsAdded(
  @property:SerialName("playerId")
  val playerId: String,
  @property:SerialName("events")
  val events: List<PlayerEvent>,
)
