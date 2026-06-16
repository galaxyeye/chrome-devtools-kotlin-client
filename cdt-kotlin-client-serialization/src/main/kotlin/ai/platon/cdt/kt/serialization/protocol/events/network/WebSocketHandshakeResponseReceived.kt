@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import ai.platon.cdt.kt.serialization.protocol.types.network.WebSocketResponse
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when WebSocket handshake response becomes available.
 */
@Serializable
data class WebSocketHandshakeResponseReceived(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("timestamp")
  val timestamp: Double,
  @property:SerialName("response")
  val response: WebSocketResponse,
)
