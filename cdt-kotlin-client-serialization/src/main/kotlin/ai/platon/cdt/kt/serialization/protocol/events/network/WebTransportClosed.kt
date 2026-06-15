@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.String

/**
 * Fired when WebTransport is disposed.
 */
@Serializable
data class WebTransportClosed(
  @SerialName("transportId")
  val transportId: String,
  @SerialName("timestamp")
  val timestamp: Double,
)
