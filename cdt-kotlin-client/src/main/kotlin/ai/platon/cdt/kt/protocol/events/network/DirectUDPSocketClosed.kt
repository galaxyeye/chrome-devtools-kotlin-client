@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Fired when direct_socket.UDPSocket is closed.
 */
@Experimental
data class DirectUDPSocketClosed(
  @param:JsonProperty("identifier")
  val identifier: String,
  @param:JsonProperty("timestamp")
  val timestamp: Double,
)
