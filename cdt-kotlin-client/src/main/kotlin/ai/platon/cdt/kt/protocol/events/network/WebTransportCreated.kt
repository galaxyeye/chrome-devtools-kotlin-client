package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.network.Initiator
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Fired upon WebTransport creation.
 */
public data class WebTransportCreated(
  @field:JsonProperty("transportId")
  public val transportId: String,
  @field:JsonProperty("url")
  public val url: String,
  @field:JsonProperty("timestamp")
  public val timestamp: Double,
  @field:JsonProperty("initiator")
  @param:Optional
  public val initiator: Initiator? = null,
)
