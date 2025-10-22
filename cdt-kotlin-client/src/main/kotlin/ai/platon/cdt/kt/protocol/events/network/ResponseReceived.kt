package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.network.ResourceType
import ai.platon.cdt.kt.protocol.types.network.Response
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Fired when HTTP response is available.
 */
data class ResponseReceived(
  @field:JsonProperty("requestId")
  val requestId: String,
  @field:JsonProperty("loaderId")
  val loaderId: String,
  @field:JsonProperty("timestamp")
  val timestamp: Double,
  @field:JsonProperty("type")
  val type: ResourceType,
  @field:JsonProperty("response")
  val response: Response,
  @field:JsonProperty("frameId")
  @param:Optional
  val frameId: String? = null,
)
