@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.String

/**
 * Fired when direct_socket.TCPSocket connection is opened.
 */
@Experimental
data class DirectTCPSocketOpened(
  @param:JsonProperty("identifier")
  val identifier: String,
  @param:JsonProperty("remoteAddr")
  val remoteAddr: String,
  @param:JsonProperty("remotePort")
  val remotePort: Int,
  @param:JsonProperty("timestamp")
  val timestamp: Double,
  @param:JsonProperty("localAddr")
  @param:Optional
  val localAddr: String? = null,
  @param:JsonProperty("localPort")
  @param:Optional
  val localPort: Int? = null,
)
