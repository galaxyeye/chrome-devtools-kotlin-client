@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import ai.platon.cdt.kt.serialization.protocol.types.network.WebSocketRequest
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when WebSocket is about to initiate handshake.
 */
@Serializable
data class WebSocketWillSendHandshakeRequest(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("timestamp")
  val timestamp: Double,
  @property:SerialName("wallTime")
  val wallTime: Double,
  @property:SerialName("request")
  val request: WebSocketRequest,
)
