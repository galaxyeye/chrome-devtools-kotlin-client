package ai.platon.cdt.kt.protocol.events.media

import ai.platon.cdt.kt.protocol.types.media.PlayerEvent
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * Send events as a list, allowing them to be batched on the browser for less
 * congestion. If batched, events must ALWAYS be in chronological order.
 */
data class PlayerEventsAdded(
  @field:JsonProperty("playerId")
  val playerId: String,
  @field:JsonProperty("events")
  val events: List<PlayerEvent>,
)
