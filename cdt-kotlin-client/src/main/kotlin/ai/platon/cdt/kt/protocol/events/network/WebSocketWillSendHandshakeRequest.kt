package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.types.network.WebSocketRequest
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Fired when WebSocket is about to initiate handshake.
 */
data class WebSocketWillSendHandshakeRequest(
  @field:JsonProperty("requestId")
  val requestId: String,
  @field:JsonProperty("timestamp")
  val timestamp: Double,
  @field:JsonProperty("wallTime")
  val wallTime: Double,
  @field:JsonProperty("request")
  val request: WebSocketRequest,
)
