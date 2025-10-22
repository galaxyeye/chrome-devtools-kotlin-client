package ai.platon.cdt.kt.protocol.events.network

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.String

/**
 * Fired when data chunk was received over the network.
 */
data class DataReceived(
  @field:JsonProperty("requestId")
  val requestId: String,
  @field:JsonProperty("timestamp")
  val timestamp: Double,
  @field:JsonProperty("dataLength")
  val dataLength: Int,
  @field:JsonProperty("encodedDataLength")
  val encodedDataLength: Int,
)
