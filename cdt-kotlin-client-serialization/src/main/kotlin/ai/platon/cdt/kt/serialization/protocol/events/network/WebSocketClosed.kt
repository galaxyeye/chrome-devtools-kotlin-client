@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when WebSocket is closed.
 */
@Serializable
data class WebSocketClosed(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("timestamp")
  val timestamp: Double,
)
