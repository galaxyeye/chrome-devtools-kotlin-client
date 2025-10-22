package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.network.Initiator
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Fired upon WebTransport creation.
 */
data class WebTransportCreated(
  @field:JsonProperty("transportId")
  val transportId: String,
  @field:JsonProperty("url")
  val url: String,
  @field:JsonProperty("timestamp")
  val timestamp: Double,
  @field:JsonProperty("initiator")
  @param:Optional
  val initiator: Initiator? = null,
)
