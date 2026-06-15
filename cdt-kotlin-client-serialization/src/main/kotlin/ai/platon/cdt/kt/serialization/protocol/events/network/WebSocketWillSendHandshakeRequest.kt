@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.network.WebSocketRequest
import kotlin.Double
import kotlin.String

/**
 * Fired when WebSocket is about to initiate handshake.
 */
@Serializable
data class WebSocketWillSendHandshakeRequest(
  @SerialName("requestId")
  val requestId: String,
  @SerialName("timestamp")
  val timestamp: Double,
  @SerialName("wallTime")
  val wallTime: Double,
  @SerialName("request")
  val request: WebSocketRequest,
)
