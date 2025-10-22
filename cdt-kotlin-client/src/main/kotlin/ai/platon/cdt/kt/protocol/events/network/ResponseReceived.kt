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
public data class ResponseReceived(
  @field:JsonProperty("requestId")
  public val requestId: String,
  @field:JsonProperty("loaderId")
  public val loaderId: String,
  @field:JsonProperty("timestamp")
  public val timestamp: Double,
  @field:JsonProperty("type")
  public val type: ResourceType,
  @field:JsonProperty("response")
  public val response: Response,
  @field:JsonProperty("frameId")
  @param:Optional
  public val frameId: String? = null,
)
