@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.media

import ai.platon.cdt.kt.serialization.protocol.types.media.Player
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Called whenever a player is created, or when a new agent joins and receives
 * a list of active players. If an agent is restored, it will receive one
 * event for each active player.
 */
@Serializable
data class PlayerCreated(
  @property:SerialName("player")
  val player: Player,
)
