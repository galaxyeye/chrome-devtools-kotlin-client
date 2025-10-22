package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.network.Initiator
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Fired upon WebSocket creation.
 */
data class WebSocketCreated(
  @field:JsonProperty("requestId")
  val requestId: String,
  @field:JsonProperty("url")
  val url: String,
  @field:JsonProperty("initiator")
  @param:Optional
  val initiator: Initiator? = null,
)
