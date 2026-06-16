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
 * Fired when direct_socket.UDPSocket connection is opened.
 */
@Serializable
@Experimental
data class DirectUDPSocketOpened(
  @property:SerialName("identifier")
  val identifier: String,
  @property:SerialName("localAddr")
  val localAddr: String,
  @property:SerialName("localPort")
  val localPort: Int,
  @property:SerialName("timestamp")
  val timestamp: Double,
  @property:SerialName("remoteAddr")
  @param:Optional
  val remoteAddr: String? = null,
  @property:SerialName("remotePort")
  @param:Optional
  val remotePort: Int? = null,
)
