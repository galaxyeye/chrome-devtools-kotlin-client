@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when EventSource message is received.
 */
@Serializable
data class EventSourceMessageReceived(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("timestamp")
  val timestamp: Double,
  @property:SerialName("eventName")
  val eventName: String,
  @property:SerialName("eventId")
  val eventId: String,
  @property:SerialName("data")
  val `data`: String,
)
