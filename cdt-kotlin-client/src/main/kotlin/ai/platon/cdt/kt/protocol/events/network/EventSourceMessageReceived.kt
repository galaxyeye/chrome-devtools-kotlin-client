package ai.platon.cdt.kt.protocol.events.network

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Fired when EventSource message is received.
 */
public data class EventSourceMessageReceived(
  @field:JsonProperty("requestId")
  public val requestId: String,
  @field:JsonProperty("timestamp")
  public val timestamp: Double,
  @field:JsonProperty("eventName")
  public val eventName: String,
  @field:JsonProperty("eventId")
  public val eventId: String,
  @field:JsonProperty("data")
  public val `data`: String,
)
