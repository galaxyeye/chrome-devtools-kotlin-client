@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.tracing

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

/**
 * Contains an bucket of collected trace events. When tracing is stopped collected events will be
 * send as a sequence of dataCollected events followed by tracingComplete event.
 */
@Serializable
data class DataCollected(
  @property:SerialName("value")
  val `value`: List<JsonObject?>,
)
