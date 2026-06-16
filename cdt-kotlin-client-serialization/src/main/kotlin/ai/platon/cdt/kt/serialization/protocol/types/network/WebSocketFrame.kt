@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * WebSocket message data. This represents an entire WebSocket message, not just a fragmented frame as the name suggests.
 */
@Serializable
data class WebSocketFrame(
  @property:SerialName("opcode")
  val opcode: Double,
  @property:SerialName("mask")
  val mask: Boolean,
  @property:SerialName("payloadData")
  val payloadData: String,
)
