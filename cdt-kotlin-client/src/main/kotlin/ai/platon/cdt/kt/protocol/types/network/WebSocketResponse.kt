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
public data class WebSocketResponse(
  @field:JsonProperty("status")
  public val status: Int,
  @field:JsonProperty("statusText")
  public val statusText: String,
  @field:JsonProperty("headers")
  public val headers: Map<String, Any?>,
  @field:JsonProperty("headersText")
  @param:Optional
  public val headersText: String? = null,
  @field:JsonProperty("requestHeaders")
  @param:Optional
  public val requestHeaders: Map<String, Any?>? = null,
  @field:JsonProperty("requestHeadersText")
  @param:Optional
  public val requestHeadersText: String? = null,
)
