@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Any
import kotlin.String
import kotlin.collections.Map

/**
 * WebSocket request data.
 */
@Serializable
data class WebSocketRequest(
  @SerialName("headers")
  val headers: Map<String, Any?>,
)
