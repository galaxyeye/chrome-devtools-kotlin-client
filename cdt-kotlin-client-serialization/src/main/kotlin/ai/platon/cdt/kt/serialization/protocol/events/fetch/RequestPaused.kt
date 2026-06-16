@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.fetch

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.fetch.HeaderEntry
import ai.platon.cdt.kt.serialization.protocol.types.network.ErrorReason
import ai.platon.cdt.kt.serialization.protocol.types.network.Request
import ai.platon.cdt.kt.serialization.protocol.types.network.ResourceType
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Issued when the domain is enabled and the request URL matches the
 * specified filter. The request is paused until the client responds
 * with one of continueRequest, failRequest or fulfillRequest.
 * The stage of the request can be determined by presence of responseErrorReason
 * and responseStatusCode -- the request is at the response stage if either
 * of these fields is present and in the request stage otherwise.
 * Redirect responses and subsequent requests are reported similarly to regular
 * responses and requests. Redirect responses may be distinguished by the value
 * of `responseStatusCode` (which is one of 301, 302, 303, 307, 308) along with
 * presence of the `location` header. Requests resulting from a redirect will
 * have `redirectedRequestId` field set.
 */
@Serializable
data class RequestPaused(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("request")
  val request: Request,
  @property:SerialName("frameId")
  val frameId: String,
  @property:SerialName("resourceType")
  val resourceType: ResourceType,
  @property:SerialName("responseErrorReason")
  @param:Optional
  val responseErrorReason: ErrorReason? = null,
  @property:SerialName("responseStatusCode")
  @param:Optional
  val responseStatusCode: Int? = null,
  @property:SerialName("responseStatusText")
  @param:Optional
  val responseStatusText: String? = null,
  @property:SerialName("responseHeaders")
  @param:Optional
  val responseHeaders: List<HeaderEntry>? = null,
  @property:SerialName("networkId")
  @param:Optional
  val networkId: String? = null,
  @property:SerialName("redirectedRequestId")
  @param:Optional
  @param:Experimental
  val redirectedRequestId: String? = null,
)
