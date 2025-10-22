package ai.platon.cdt.kt.protocol.events.network

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Fired when WebSocket message error occurs.
 */
data class WebSocketFrameError(
  @field:JsonProperty("requestId")
  val requestId: String,
  @field:JsonProperty("timestamp")
  val timestamp: Double,
  @field:JsonProperty("errorMessage")
  val errorMessage: String,
)
