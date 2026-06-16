@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.events.network

import ai.platon.browser4.chrome.protocol.support.annotations.Experimental
import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import ai.platon.browser4.chrome.protocol.types.network.Initiator
import ai.platon.browser4.chrome.protocol.types.network.RenderBlockingBehavior
import ai.platon.browser4.chrome.protocol.types.network.Request
import ai.platon.browser4.chrome.protocol.types.network.ResourceType
import ai.platon.browser4.chrome.protocol.types.network.Response
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when page is about to send HTTP request.
 */
@Serializable
data class RequestWillBeSent(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("loaderId")
  val loaderId: String,
  @property:SerialName("documentURL")
  val documentURL: String,
  @property:SerialName("request")
  val request: Request,
  @property:SerialName("timestamp")
  val timestamp: Double,
  @property:SerialName("wallTime")
  val wallTime: Double,
  @property:SerialName("initiator")
  val initiator: Initiator,
  @property:SerialName("redirectHasExtraInfo")
  @param:Experimental
  val redirectHasExtraInfo: Boolean,
  @property:SerialName("redirectResponse")
  @param:Optional
  val redirectResponse: Response? = null,
  @property:SerialName("type")
  @param:Optional
  val type: ResourceType? = null,
  @property:SerialName("frameId")
  @param:Optional
  val frameId: String? = null,
  @property:SerialName("hasUserGesture")
  @param:Optional
  val hasUserGesture: Boolean? = null,
  @property:SerialName("renderBlockingBehavior")
  @param:Optional
  @param:Experimental
  val renderBlockingBehavior: RenderBlockingBehavior? = null,
)
