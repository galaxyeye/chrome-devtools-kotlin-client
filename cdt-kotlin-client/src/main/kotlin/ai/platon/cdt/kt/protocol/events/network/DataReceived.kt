package ai.platon.cdt.kt.protocol.events.network

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.String

/**
 * Fired when data chunk was received over the network.
 */
public data class DataReceived(
  @field:JsonProperty("requestId")
  public val requestId: String,
  @field:JsonProperty("timestamp")
  public val timestamp: Double,
  @field:JsonProperty("dataLength")
  public val dataLength: Int,
  @field:JsonProperty("encodedDataLength")
  public val encodedDataLength: Int,
)
