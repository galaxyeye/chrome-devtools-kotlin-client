@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when WebTransport is disposed.
 */
@Serializable
data class WebTransportClosed(
  @property:SerialName("transportId")
  val transportId: String,
  @property:SerialName("timestamp")
  val timestamp: Double,
)
