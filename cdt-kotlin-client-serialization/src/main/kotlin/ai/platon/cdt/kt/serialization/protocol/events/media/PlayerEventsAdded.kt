@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.media
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.media.PlayerEvent
import kotlin.String
import kotlin.collections.List

/**
 * Send events as a list, allowing them to be batched on the browser for less
 * congestion. If batched, events must ALWAYS be in chronological order.
 */
@Serializable
data class PlayerEventsAdded(
  @SerialName("playerId")
  val playerId: String,
  @SerialName("events")
  val events: List<PlayerEvent>,
)
