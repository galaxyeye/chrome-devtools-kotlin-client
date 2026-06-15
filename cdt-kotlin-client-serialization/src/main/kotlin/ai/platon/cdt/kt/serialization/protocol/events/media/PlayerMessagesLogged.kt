@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.media
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.media.PlayerMessage
import kotlin.String
import kotlin.collections.List

/**
 * Send a list of any messages that need to be delivered.
 */
@Serializable
data class PlayerMessagesLogged(
  @SerialName("playerId")
  val playerId: String,
  @SerialName("messages")
  val messages: List<PlayerMessage>,
)
