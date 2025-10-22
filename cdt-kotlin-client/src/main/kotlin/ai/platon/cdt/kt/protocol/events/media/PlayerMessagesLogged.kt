package ai.platon.cdt.kt.protocol.events.media

import ai.platon.cdt.kt.protocol.types.media.PlayerMessage
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * Send a list of any messages that need to be delivered.
 */
data class PlayerMessagesLogged(
  @field:JsonProperty("playerId")
  val playerId: String,
  @field:JsonProperty("messages")
  val messages: List<PlayerMessage>,
)
