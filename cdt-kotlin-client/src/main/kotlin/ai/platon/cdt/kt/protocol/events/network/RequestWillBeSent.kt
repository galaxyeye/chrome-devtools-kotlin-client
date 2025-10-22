package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.network.Initiator
import ai.platon.cdt.kt.protocol.types.network.Request
import ai.platon.cdt.kt.protocol.types.network.ResourceType
import ai.platon.cdt.kt.protocol.types.network.Response
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.String

/**
 * Fired when page is about to send HTTP request.
 */
data class RequestWillBeSent(
  @field:JsonProperty("requestId")
  val requestId: String,
  @field:JsonProperty("loaderId")
  val loaderId: String,
  @field:JsonProperty("documentURL")
  val documentURL: String,
  @field:JsonProperty("request")
  val request: Request,
  @field:JsonProperty("timestamp")
  val timestamp: Double,
  @field:JsonProperty("wallTime")
  val wallTime: Double,
  @field:JsonProperty("initiator")
  val initiator: Initiator,
  @field:JsonProperty("redirectResponse")
  @param:Optional
  val redirectResponse: Response? = null,
  @field:JsonProperty("type")
  @param:Optional
  val type: ResourceType? = null,
  @field:JsonProperty("frameId")
  @param:Optional
  val frameId: String? = null,
  @field:JsonProperty("hasUserGesture")
  @param:Optional
  val hasUserGesture: Boolean? = null,
)
