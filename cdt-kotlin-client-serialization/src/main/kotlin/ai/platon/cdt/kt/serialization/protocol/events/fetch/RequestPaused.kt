@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.fetch
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.fetch.HeaderEntry
import ai.platon.cdt.kt.serialization.protocol.types.network.ErrorReason
import ai.platon.cdt.kt.serialization.protocol.types.network.Request
import ai.platon.cdt.kt.serialization.protocol.types.network.ResourceType
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
@Serializable
data class RequestPaused(
  @SerialName("requestId")
  val requestId: String,
  @SerialName("request")
  val request: Request,
  @SerialName("frameId")
  val frameId: String,
  @SerialName("resourceType")
  val resourceType: ResourceType,
  @SerialName("responseErrorReason")
  @param:Optional
  val responseErrorReason: ErrorReason? = null,
  @SerialName("responseStatusCode")
  @param:Optional
  val responseStatusCode: Int? = null,
  @SerialName("responseHeaders")
  @param:Optional
  val responseHeaders: List<HeaderEntry>? = null,
  @SerialName("networkId")
  @param:Optional
  val networkId: String? = null,
)
