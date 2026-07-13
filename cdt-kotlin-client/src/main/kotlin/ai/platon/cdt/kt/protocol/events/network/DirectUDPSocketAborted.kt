@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Fired when direct_socket.UDPSocket is aborted.
 */
@Experimental
data class DirectUDPSocketAborted(
  @param:JsonProperty("identifier")
  val identifier: String,
  @param:JsonProperty("errorMessage")
  val errorMessage: String,
  @param:JsonProperty("timestamp")
  val timestamp: Double,
)
