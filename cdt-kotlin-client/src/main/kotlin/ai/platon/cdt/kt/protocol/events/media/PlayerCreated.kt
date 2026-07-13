@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.media

import ai.platon.cdt.kt.protocol.types.media.Player
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Called whenever a player is created, or when a new agent joins and receives
 * a list of active players. If an agent is restored, it will receive one
 * event for each active player.
 */
data class PlayerCreated(
  @param:JsonProperty("player")
  val player: Player,
)
