@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.network.AuthChallenge
import ai.platon.cdt.kt.serialization.protocol.types.network.ErrorReason
import ai.platon.cdt.kt.serialization.protocol.types.network.Request
import ai.platon.cdt.kt.serialization.protocol.types.network.ResourceType
import kotlin.Any
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.Int
import kotlin.String
import kotlin.collections.Map

/**
 * Details of an intercepted HTTP request, which must be either allowed, blocked, modified or
 * mocked.
 * Deprecated, use Fetch.requestPaused instead.
 */
@Experimental
@Deprecated("Deprecated")
@Serializable
data class RequestIntercepted(
  @SerialName("interceptionId")
  val interceptionId: String,
  @SerialName("request")
  val request: Request,
  @SerialName("frameId")
  val frameId: String,
  @SerialName("resourceType")
  val resourceType: ResourceType,
  @SerialName("isNavigationRequest")
  val isNavigationRequest: Boolean,
  @SerialName("isDownload")
  @param:Optional
  val isDownload: Boolean? = null,
  @SerialName("redirectUrl")
  @param:Optional
  val redirectUrl: String? = null,
  @SerialName("authChallenge")
  @param:Optional
  val authChallenge: AuthChallenge? = null,
  @SerialName("responseErrorReason")
  @param:Optional
  val responseErrorReason: ErrorReason? = null,
  @SerialName("responseStatusCode")
  @param:Optional
  val responseStatusCode: Int? = null,
  @SerialName("responseHeaders")
  @param:Optional
  val responseHeaders: Map<String, Any?>? = null,
  @SerialName("requestId")
  @param:Optional
  val requestId: String? = null,
)
