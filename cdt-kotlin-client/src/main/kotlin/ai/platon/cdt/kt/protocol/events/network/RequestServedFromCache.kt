package ai.platon.cdt.kt.protocol.events.network

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Fired if request ended up loading from cache.
 */
data class RequestServedFromCache(
  @field:JsonProperty("requestId")
  val requestId: String,
)
