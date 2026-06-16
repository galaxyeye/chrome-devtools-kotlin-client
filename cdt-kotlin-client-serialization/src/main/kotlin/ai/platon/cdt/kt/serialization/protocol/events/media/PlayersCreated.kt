@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.media

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Called whenever a player is created, or when a new agent joins and receives
 * a list of active players. If an agent is restored, it will receive the full
 * list of player ids and all events again.
 */
@Serializable
data class PlayersCreated(
  @property:SerialName("players")
  val players: List<String>,
)
