@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.network.DirectUDPSocketOptions
import ai.platon.cdt.kt.serialization.protocol.types.network.Initiator
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired upon direct_socket.UDPSocket creation.
 */
@Serializable
@Experimental
data class DirectUDPSocketCreated(
  @property:SerialName("identifier")
  val identifier: String,
  @property:SerialName("options")
  val options: DirectUDPSocketOptions,
  @property:SerialName("timestamp")
  val timestamp: Double,
  @property:SerialName("initiator")
  @param:Optional
  val initiator: Initiator? = null,
)
