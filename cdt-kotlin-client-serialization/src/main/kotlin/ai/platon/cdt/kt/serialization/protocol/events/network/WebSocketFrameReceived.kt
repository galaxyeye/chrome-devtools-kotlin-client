@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import ai.platon.cdt.kt.serialization.protocol.types.network.WebSocketFrame
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when WebSocket message is received.
 */
@Serializable
data class WebSocketFrameReceived(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("timestamp")
  val timestamp: Double,
  @property:SerialName("response")
  val response: WebSocketFrame,
)
