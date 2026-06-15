@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.network.WebSocketFrame
import kotlin.Double
import kotlin.String

/**
 * Fired when WebSocket message is received.
 */
@Serializable
data class WebSocketFrameReceived(
  @SerialName("requestId")
  val requestId: String,
  @SerialName("timestamp")
  val timestamp: Double,
  @SerialName("response")
  val response: WebSocketFrame,
)
