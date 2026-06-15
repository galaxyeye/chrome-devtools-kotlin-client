@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.String

/**
 * Fired when WebTransport handshake is finished.
 */
@Serializable
data class WebTransportConnectionEstablished(
  @SerialName("transportId")
  val transportId: String,
  @SerialName("timestamp")
  val timestamp: Double,
)
