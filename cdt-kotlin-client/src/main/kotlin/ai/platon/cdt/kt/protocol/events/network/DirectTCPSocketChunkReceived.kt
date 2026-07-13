@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Fired when data is received from tcp direct socket stream.
 */
@Experimental
data class DirectTCPSocketChunkReceived(
  @param:JsonProperty("identifier")
  val identifier: String,
  @param:JsonProperty("data")
  val `data`: String,
  @param:JsonProperty("timestamp")
  val timestamp: Double,
)
