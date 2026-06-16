@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

/**
 * WebSocket request data.
 */
@Serializable
data class WebSocketRequest(
  @property:SerialName("headers")
  val headers: JsonObject?,
)
