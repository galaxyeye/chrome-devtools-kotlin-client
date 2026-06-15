@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Any
import kotlin.Int
import kotlin.String
import kotlin.collections.Map

/**
 * WebSocket response data.
 */
@Serializable
data class WebSocketResponse(
  @SerialName("status")
  val status: Int,
  @SerialName("statusText")
  val statusText: String,
  @SerialName("headers")
  val headers: Map<String, Any?>,
  @SerialName("headersText")
  @param:Optional
  val headersText: String? = null,
  @SerialName("requestHeaders")
  @param:Optional
  val requestHeaders: Map<String, Any?>? = null,
  @SerialName("requestHeadersText")
  @param:Optional
  val requestHeadersText: String? = null,
)
