@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when direct_socket.UDPSocket is aborted.
 */
@Serializable
@Experimental
data class DirectUDPSocketAborted(
  @property:SerialName("identifier")
  val identifier: String,
  @property:SerialName("errorMessage")
  val errorMessage: String,
  @property:SerialName("timestamp")
  val timestamp: Double,
)
