package ai.platon.cdt.kt.protocol.events.fetch

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.fetch.HeaderEntry
import ai.platon.cdt.kt.protocol.types.network.ErrorReason
import ai.platon.cdt.kt.protocol.types.network.Request
import ai.platon.cdt.kt.protocol.types.network.ResourceType
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Issued when the domain is enabled and the request URL matches the
 * specified filter. The request is paused until the client responds
 * with one of continueRequest, failRequest or fulfillRequest.
 * The stage of the request can be determined by presence of responseErrorReason
 * and responseStatusCode -- the request is at the response stage if either
 * of these fields is present and in the request stage otherwise.
 */
public data class RequestPaused(
  @field:JsonProperty("requestId")
  public val requestId: String,
  @field:JsonProperty("request")
  public val request: Request,
  @field:JsonProperty("frameId")
  public val frameId: String,
  @field:JsonProperty("resourceType")
  public val resourceType: ResourceType,
  @field:JsonProperty("responseErrorReason")
  @param:Optional
  public val responseErrorReason: ErrorReason? = null,
  @field:JsonProperty("responseStatusCode")
  @param:Optional
  public val responseStatusCode: Int? = null,
  @field:JsonProperty("responseHeaders")
  @param:Optional
  public val responseHeaders: List<HeaderEntry>? = null,
  @field:JsonProperty("networkId")
  @param:Optional
  public val networkId: String? = null,
)
