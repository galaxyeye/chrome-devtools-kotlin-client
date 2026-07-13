@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when direct_socket.TCPSocket connection is opened.
 */
@Serializable
@Experimental
data class DirectTCPSocketOpened(
  @property:SerialName("identifier")
  val identifier: String,
  @property:SerialName("remoteAddr")
  val remoteAddr: String,
  @property:SerialName("remotePort")
  val remotePort: Int,
  @property:SerialName("timestamp")
  val timestamp: Double,
  @property:SerialName("localAddr")
  @param:Optional
  val localAddr: String? = null,
  @property:SerialName("localPort")
  @param:Optional
  val localPort: Int? = null,
)
