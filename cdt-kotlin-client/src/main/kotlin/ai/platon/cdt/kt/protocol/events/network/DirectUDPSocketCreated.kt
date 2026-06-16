@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.network.DirectUDPSocketOptions
import ai.platon.cdt.kt.protocol.types.network.Initiator
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Fired upon direct_socket.UDPSocket creation.
 */
@Experimental
data class DirectUDPSocketCreated(
  @param:JsonProperty("identifier")
  val identifier: String,
  @param:JsonProperty("options")
  val options: DirectUDPSocketOptions,
  @param:JsonProperty("timestamp")
  val timestamp: Double,
  @param:JsonProperty("initiator")
  @param:Optional
  val initiator: Initiator? = null,
)
