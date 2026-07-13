@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.String
import kotlin.collections.Map

/**
 * Fired when 103 Early Hints headers is received in addition to the common response.
 * Not every responseReceived event will have an responseReceivedEarlyHints fired.
 * Only one responseReceivedEarlyHints may be fired for eached responseReceived event.
 */
@Experimental
data class ResponseReceivedEarlyHints(
  @param:JsonProperty("requestId")
  val requestId: String,
  @param:JsonProperty("headers")
  val headers: Map<String, Any?>,
)
