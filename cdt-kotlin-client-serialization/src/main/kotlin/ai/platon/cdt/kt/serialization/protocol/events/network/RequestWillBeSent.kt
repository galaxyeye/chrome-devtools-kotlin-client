@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.network.Initiator
import ai.platon.cdt.kt.serialization.protocol.types.network.Request
import ai.platon.cdt.kt.serialization.protocol.types.network.ResourceType
import ai.platon.cdt.kt.serialization.protocol.types.network.Response
import kotlin.Boolean
import kotlin.Double
import kotlin.String

/**
 * Fired when page is about to send HTTP request.
 */
@Serializable
data class RequestWillBeSent(
  @SerialName("requestId")
  val requestId: String,
  @SerialName("loaderId")
  val loaderId: String,
  @SerialName("documentURL")
  val documentURL: String,
  @SerialName("request")
  val request: Request,
  @SerialName("timestamp")
  val timestamp: Double,
  @SerialName("wallTime")
  val wallTime: Double,
  @SerialName("initiator")
  val initiator: Initiator,
  @SerialName("redirectResponse")
  @param:Optional
  val redirectResponse: Response? = null,
  @SerialName("type")
  @param:Optional
  val type: ResourceType? = null,
  @SerialName("frameId")
  @param:Optional
  val frameId: String? = null,
  @SerialName("hasUserGesture")
  @param:Optional
  val hasUserGesture: Boolean? = null,
)
