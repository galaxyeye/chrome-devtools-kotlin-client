@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.String

/**
 * Fired when data chunk was received over the network.
 */
data class DataReceived(
  @param:JsonProperty("requestId")
  val requestId: String,
  @param:JsonProperty("timestamp")
  val timestamp: Double,
  @param:JsonProperty("dataLength")
  val dataLength: Int,
  @param:JsonProperty("encodedDataLength")
  val encodedDataLength: Int,
  @param:JsonProperty("data")
  @param:Optional
  @param:Experimental
  val `data`: String? = null,
)
