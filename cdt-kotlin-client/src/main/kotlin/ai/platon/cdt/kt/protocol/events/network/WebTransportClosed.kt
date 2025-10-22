package ai.platon.cdt.kt.protocol.events.network

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Fired when WebTransport is disposed.
 */
public data class WebTransportClosed(
  @field:JsonProperty("transportId")
  public val transportId: String,
  @field:JsonProperty("timestamp")
  public val timestamp: Double,
)
