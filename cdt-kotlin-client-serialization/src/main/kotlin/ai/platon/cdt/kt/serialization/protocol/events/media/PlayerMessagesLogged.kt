@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.media

import ai.platon.cdt.kt.serialization.protocol.types.media.PlayerMessage
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Send a list of any messages that need to be delivered.
 */
@Serializable
data class PlayerMessagesLogged(
  @property:SerialName("playerId")
  val playerId: String,
  @property:SerialName("messages")
  val messages: List<PlayerMessage>,
)
