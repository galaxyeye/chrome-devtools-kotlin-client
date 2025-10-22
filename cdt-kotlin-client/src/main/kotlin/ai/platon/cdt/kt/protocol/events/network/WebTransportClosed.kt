package ai.platon.cdt.kt.protocol.events.network

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Fired when WebTransport is disposed.
 */
data class WebTransportClosed(
  @field:JsonProperty("transportId")
  val transportId: String,
  @field:JsonProperty("timestamp")
  val timestamp: Double,
)
