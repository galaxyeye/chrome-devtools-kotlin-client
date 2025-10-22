package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.types.network.WebSocketRequest
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Fired when WebSocket is about to initiate handshake.
 */
public data class WebSocketWillSendHandshakeRequest(
  @field:JsonProperty("requestId")
  public val requestId: String,
  @field:JsonProperty("timestamp")
  public val timestamp: Double,
  @field:JsonProperty("wallTime")
  public val wallTime: Double,
  @field:JsonProperty("request")
  public val request: WebSocketRequest,
)
