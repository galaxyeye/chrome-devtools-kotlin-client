@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.String

/**
 * Fired when EventSource message is received.
 */
@Serializable
data class EventSourceMessageReceived(
  @SerialName("requestId")
  val requestId: String,
  @SerialName("timestamp")
  val timestamp: Double,
  @SerialName("eventName")
  val eventName: String,
  @SerialName("eventId")
  val eventId: String,
  @SerialName("data")
  val `data`: String,
)
