@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.Int
import kotlin.String

/**
 * Fired when data chunk was received over the network.
 */
@Serializable
data class DataReceived(
  @SerialName("requestId")
  val requestId: String,
  @SerialName("timestamp")
  val timestamp: Double,
  @SerialName("dataLength")
  val dataLength: Int,
  @SerialName("encodedDataLength")
  val encodedDataLength: Int,
)
