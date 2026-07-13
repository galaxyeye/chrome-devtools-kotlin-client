@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.tracing

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

/**
 * Contains a bucket of collected trace events. When tracing is stopped collected events will be
 * sent as a sequence of dataCollected events followed by tracingComplete event.
 */
@Experimental
data class DataCollected(
  @param:JsonProperty("value")
  val `value`: List<Map<String, Any?>>,
)
