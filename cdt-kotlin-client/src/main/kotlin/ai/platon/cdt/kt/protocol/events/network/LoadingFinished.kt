@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.network

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Fired when HTTP request has finished loading.
 */
data class LoadingFinished(
  @param:JsonProperty("requestId")
  val requestId: String,
  @param:JsonProperty("timestamp")
  val timestamp: Double,
  @param:JsonProperty("encodedDataLength")
  val encodedDataLength: Double,
)
