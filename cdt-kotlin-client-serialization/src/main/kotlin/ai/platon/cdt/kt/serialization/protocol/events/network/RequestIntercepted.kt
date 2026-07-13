@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.network.AuthChallenge
import ai.platon.cdt.kt.serialization.protocol.types.network.ErrorReason
import ai.platon.cdt.kt.serialization.protocol.types.network.Request
import ai.platon.cdt.kt.serialization.protocol.types.network.ResourceType
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

/**
 * Details of an intercepted HTTP request, which must be either allowed, blocked, modified or
 * mocked.
 * Deprecated, use Fetch.requestPaused instead.
 */
@Serializable
@Experimental
@Deprecated("Deprecated")
data class RequestIntercepted(
  @property:SerialName("interceptionId")
  val interceptionId: String,
  @property:SerialName("request")
  val request: Request,
  @property:SerialName("frameId")
  val frameId: String,
  @property:SerialName("resourceType")
  val resourceType: ResourceType,
  @property:SerialName("isNavigationRequest")
  val isNavigationRequest: Boolean,
  @property:SerialName("isDownload")
  @param:Optional
  val isDownload: Boolean? = null,
  @property:SerialName("redirectUrl")
  @param:Optional
  val redirectUrl: String? = null,
  @property:SerialName("authChallenge")
  @param:Optional
  val authChallenge: AuthChallenge? = null,
  @property:SerialName("responseErrorReason")
  @param:Optional
  val responseErrorReason: ErrorReason? = null,
  @property:SerialName("responseStatusCode")
  @param:Optional
  val responseStatusCode: Int? = null,
  @property:SerialName("responseHeaders")
  @param:Optional
  val responseHeaders: JsonObject? = null,
  @property:SerialName("requestId")
  @param:Optional
  val requestId: String? = null,
)
