package ai.platon.cdt.kt.protocol.events.network

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Fired when EventSource message is received.
 */
data class EventSourceMessageReceived(
  @field:JsonProperty("requestId")
  val requestId: String,
  @field:JsonProperty("timestamp")
  val timestamp: Double,
  @field:JsonProperty("eventName")
  val eventName: String,
  @field:JsonProperty("eventId")
  val eventId: String,
  @field:JsonProperty("data")
  val `data`: String,
)
