@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

/**
 * Fired when 103 Early Hints headers is received in addition to the common response.
 * Not every responseReceived event will have an responseReceivedEarlyHints fired.
 * Only one responseReceivedEarlyHints may be fired for eached responseReceived event.
 */
@Serializable
@Experimental
data class ResponseReceivedEarlyHints(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("headers")
  val headers: JsonObject?,
)
