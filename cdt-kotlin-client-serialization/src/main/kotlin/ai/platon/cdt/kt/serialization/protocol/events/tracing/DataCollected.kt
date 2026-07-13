@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.tracing

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

/**
 * Contains a bucket of collected trace events. When tracing is stopped collected events will be
 * sent as a sequence of dataCollected events followed by tracingComplete event.
 */
@Serializable
@Experimental
data class DataCollected(
  @property:SerialName("value")
  val `value`: List<JsonObject?>,
)
