package ai.platon.cdt.kt.protocol.events.network

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Fired when WebSocket is closed.
 */
data class WebSocketClosed(
  @field:JsonProperty("requestId")
  val requestId: String,
  @field:JsonProperty("timestamp")
  val timestamp: Double,
)
