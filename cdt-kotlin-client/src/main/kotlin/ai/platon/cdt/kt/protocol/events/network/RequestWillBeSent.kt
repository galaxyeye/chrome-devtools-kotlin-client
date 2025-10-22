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
public data class RequestWillBeSent(
  @field:JsonProperty("requestId")
  public val requestId: String,
  @field:JsonProperty("loaderId")
  public val loaderId: String,
  @field:JsonProperty("documentURL")
  public val documentURL: String,
  @field:JsonProperty("request")
  public val request: Request,
  @field:JsonProperty("timestamp")
  public val timestamp: Double,
  @field:JsonProperty("wallTime")
  public val wallTime: Double,
  @field:JsonProperty("initiator")
  public val initiator: Initiator,
  @field:JsonProperty("redirectResponse")
  @param:Optional
  public val redirectResponse: Response? = null,
  @field:JsonProperty("type")
  @param:Optional
  public val type: ResourceType? = null,
  @field:JsonProperty("frameId")
  @param:Optional
  public val frameId: String? = null,
  @field:JsonProperty("hasUserGesture")
  @param:Optional
  public val hasUserGesture: Boolean? = null,
)
