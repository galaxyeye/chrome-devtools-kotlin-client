@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.network.DirectUDPMessage
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when message is received from udp direct socket stream.
 */
@Serializable
@Experimental
data class DirectUDPSocketChunkReceived(
  @property:SerialName("identifier")
  val identifier: String,
  @property:SerialName("message")
  val message: DirectUDPMessage,
  @property:SerialName("timestamp")
  val timestamp: Double,
)
