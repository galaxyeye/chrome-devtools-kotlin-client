@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.tracing
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Any
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

/**
 * Contains an bucket of collected trace events. When tracing is stopped collected events will be
 * send as a sequence of dataCollected events followed by tracingComplete event.
 */
@Serializable
data class DataCollected(
  @SerialName("value")
  val `value`: List<Map<String, Any?>>,
)
