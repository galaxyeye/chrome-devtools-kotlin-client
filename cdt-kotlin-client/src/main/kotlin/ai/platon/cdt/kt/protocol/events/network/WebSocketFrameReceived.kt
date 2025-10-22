package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.types.network.WebSocketFrame
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Fired when WebSocket message is received.
 */
data class WebSocketFrameReceived(
  @field:JsonProperty("requestId")
  val requestId: String,
  @field:JsonProperty("timestamp")
  val timestamp: Double,
  @field:JsonProperty("response")
  val response: WebSocketFrame,
)
