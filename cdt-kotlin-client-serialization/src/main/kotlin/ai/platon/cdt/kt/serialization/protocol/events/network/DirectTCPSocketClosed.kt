@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when direct_socket.TCPSocket is closed.
 */
@Serializable
@Experimental
data class DirectTCPSocketClosed(
  @property:SerialName("identifier")
  val identifier: String,
  @property:SerialName("timestamp")
  val timestamp: Double,
)
