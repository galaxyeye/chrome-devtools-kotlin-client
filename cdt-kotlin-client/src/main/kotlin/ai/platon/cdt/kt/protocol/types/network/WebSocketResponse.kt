package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.Int
import kotlin.String
import kotlin.collections.Map

/**
 * WebSocket response data.
 */
data class WebSocketResponse(
  @field:JsonProperty("status")
  val status: Int,
  @field:JsonProperty("statusText")
  val statusText: String,
  @field:JsonProperty("headers")
  val headers: Map<String, Any?>,
  @field:JsonProperty("headersText")
  @param:Optional
  val headersText: String? = null,
  @field:JsonProperty("requestHeaders")
  @param:Optional
  val requestHeaders: Map<String, Any?>? = null,
  @field:JsonProperty("requestHeadersText")
  @param:Optional
  val requestHeadersText: String? = null,
)
