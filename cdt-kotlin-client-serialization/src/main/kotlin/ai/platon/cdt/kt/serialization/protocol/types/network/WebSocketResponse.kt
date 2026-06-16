@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

/**
 * WebSocket response data.
 */
@Serializable
data class WebSocketResponse(
  @property:SerialName("status")
  val status: Int,
  @property:SerialName("statusText")
  val statusText: String,
  @property:SerialName("headers")
  val headers: JsonObject?,
  @property:SerialName("headersText")
  @param:Optional
  val headersText: String? = null,
  @property:SerialName("requestHeaders")
  @param:Optional
  val requestHeaders: JsonObject? = null,
  @property:SerialName("requestHeadersText")
  @param:Optional
  val requestHeadersText: String? = null,
)
