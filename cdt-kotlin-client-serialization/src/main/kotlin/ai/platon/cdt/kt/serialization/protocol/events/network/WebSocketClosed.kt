@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.String

/**
 * Fired when WebSocket is closed.
 */
@Serializable
data class WebSocketClosed(
  @SerialName("requestId")
  val requestId: String,
  @SerialName("timestamp")
  val timestamp: Double,
)
