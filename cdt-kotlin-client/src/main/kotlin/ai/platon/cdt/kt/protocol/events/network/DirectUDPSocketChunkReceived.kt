@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.types.network.DirectUDPMessage
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Fired when message is received from udp direct socket stream.
 */
@Experimental
data class DirectUDPSocketChunkReceived(
  @param:JsonProperty("identifier")
  val identifier: String,
  @param:JsonProperty("message")
  val message: DirectUDPMessage,
  @param:JsonProperty("timestamp")
  val timestamp: Double,
)
