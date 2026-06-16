@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.network.DirectTCPSocketOptions
import ai.platon.cdt.kt.serialization.protocol.types.network.Initiator
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired upon direct_socket.TCPSocket creation.
 */
@Serializable
@Experimental
data class DirectTCPSocketCreated(
  @property:SerialName("identifier")
  val identifier: String,
  @property:SerialName("remoteAddr")
  val remoteAddr: String,
  @property:SerialName("remotePort")
  val remotePort: Int,
  @property:SerialName("options")
  val options: DirectTCPSocketOptions,
  @property:SerialName("timestamp")
  val timestamp: Double,
  @property:SerialName("initiator")
  @param:Optional
  val initiator: Initiator? = null,
)
