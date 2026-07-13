@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.network.DirectTCPSocketOptions
import ai.platon.cdt.kt.protocol.types.network.Initiator
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.String

/**
 * Fired upon direct_socket.TCPSocket creation.
 */
@Experimental
data class DirectTCPSocketCreated(
  @param:JsonProperty("identifier")
  val identifier: String,
  @param:JsonProperty("remoteAddr")
  val remoteAddr: String,
  @param:JsonProperty("remotePort")
  val remotePort: Int,
  @param:JsonProperty("options")
  val options: DirectTCPSocketOptions,
  @param:JsonProperty("timestamp")
  val timestamp: Double,
  @param:JsonProperty("initiator")
  @param:Optional
  val initiator: Initiator? = null,
)
