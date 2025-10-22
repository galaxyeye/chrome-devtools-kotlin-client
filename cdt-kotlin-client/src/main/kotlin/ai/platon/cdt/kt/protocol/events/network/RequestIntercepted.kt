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
public data class RequestIntercepted(
  @field:JsonProperty("interceptionId")
  public val interceptionId: String,
  @field:JsonProperty("request")
  public val request: Request,
  @field:JsonProperty("frameId")
  public val frameId: String,
  @field:JsonProperty("resourceType")
  public val resourceType: ResourceType,
  @field:JsonProperty("isNavigationRequest")
  public val isNavigationRequest: Boolean,
  @field:JsonProperty("isDownload")
  @param:Optional
  public val isDownload: Boolean? = null,
  @field:JsonProperty("redirectUrl")
  @param:Optional
  public val redirectUrl: String? = null,
  @field:JsonProperty("authChallenge")
  @param:Optional
  public val authChallenge: AuthChallenge? = null,
  @field:JsonProperty("responseErrorReason")
  @param:Optional
  public val responseErrorReason: ErrorReason? = null,
  @field:JsonProperty("responseStatusCode")
  @param:Optional
  public val responseStatusCode: Int? = null,
  @field:JsonProperty("responseHeaders")
  @param:Optional
  public val responseHeaders: Map<String, Any?>? = null,
  @field:JsonProperty("requestId")
  @param:Optional
  public val requestId: String? = null,
)
