@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Boolean
import kotlin.Double
import kotlin.String

/**
 * WebSocket message data. This represents an entire WebSocket message, not just a fragmented frame as the name suggests.
 */
@Serializable
data class WebSocketFrame(
  @SerialName("opcode")
  val opcode: Double,
  @SerialName("mask")
  val mask: Boolean,
  @SerialName("payloadData")
  val payloadData: String,
)
