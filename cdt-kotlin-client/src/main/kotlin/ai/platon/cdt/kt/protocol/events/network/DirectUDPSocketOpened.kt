@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.String

/**
 * Fired when direct_socket.UDPSocket connection is opened.
 */
@Experimental
data class DirectUDPSocketOpened(
  @param:JsonProperty("identifier")
  val identifier: String,
  @param:JsonProperty("localAddr")
  val localAddr: String,
  @param:JsonProperty("localPort")
  val localPort: Int,
  @param:JsonProperty("timestamp")
  val timestamp: Double,
  @param:JsonProperty("remoteAddr")
  @param:Optional
  val remoteAddr: String? = null,
  @param:JsonProperty("remotePort")
  @param:Optional
  val remotePort: Int? = null,
)
