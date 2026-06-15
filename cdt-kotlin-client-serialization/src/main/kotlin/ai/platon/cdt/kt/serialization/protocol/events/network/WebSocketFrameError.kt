@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.String

/**
 * Fired when WebSocket message error occurs.
 */
@Serializable
data class WebSocketFrameError(
  @SerialName("requestId")
  val requestId: String,
  @SerialName("timestamp")
  val timestamp: Double,
  @SerialName("errorMessage")
  val errorMessage: String,
)
