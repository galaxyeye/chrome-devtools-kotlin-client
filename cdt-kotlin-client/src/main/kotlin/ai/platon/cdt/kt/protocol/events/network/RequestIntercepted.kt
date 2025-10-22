package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.network.AuthChallenge
import ai.platon.cdt.kt.protocol.types.network.ErrorReason
import ai.platon.cdt.kt.protocol.types.network.Request
import ai.platon.cdt.kt.protocol.types.network.ResourceType
import com.fasterxml.jackson.`annotation`.JsonProperty
import java.lang.Deprecated
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.Map

/**
 * Details of an intercepted HTTP request, which must be either allowed, blocked, modified or
 * mocked.
 * Deprecated, use Fetch.requestPaused instead.
 */
@Experimental
@Deprecated
data class RequestIntercepted(
  @field:JsonProperty("interceptionId")
  val interceptionId: String,
  @field:JsonProperty("request")
  val request: Request,
  @field:JsonProperty("frameId")
  val frameId: String,
  @field:JsonProperty("resourceType")
  val resourceType: ResourceType,
  @field:JsonProperty("isNavigationRequest")
  val isNavigationRequest: Boolean,
  @field:JsonProperty("isDownload")
  @param:Optional
  val isDownload: Boolean? = null,
  @field:JsonProperty("redirectUrl")
  @param:Optional
  val redirectUrl: String? = null,
  @field:JsonProperty("authChallenge")
  @param:Optional
  val authChallenge: AuthChallenge? = null,
  @field:JsonProperty("responseErrorReason")
  @param:Optional
  val responseErrorReason: ErrorReason? = null,
  @field:JsonProperty("responseStatusCode")
  @param:Optional
  val responseStatusCode: Int? = null,
  @field:JsonProperty("responseHeaders")
  @param:Optional
  val responseHeaders: Map<String, Any?>? = null,
  @field:JsonProperty("requestId")
  @param:Optional
  val requestId: String? = null,
)
