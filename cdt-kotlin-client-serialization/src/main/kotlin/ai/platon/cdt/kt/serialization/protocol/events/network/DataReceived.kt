@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when data chunk was received over the network.
 */
@Serializable
data class DataReceived(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("timestamp")
  val timestamp: Double,
  @property:SerialName("dataLength")
  val dataLength: Int,
  @property:SerialName("encodedDataLength")
  val encodedDataLength: Int,
)
