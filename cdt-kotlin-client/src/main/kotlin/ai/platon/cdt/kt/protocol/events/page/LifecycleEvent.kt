package ai.platon.cdt.kt.protocol.events.page

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Fired for top level page lifecycle events such as navigation, load, paint, etc.
 */
data class LifecycleEvent(
  @field:JsonProperty("frameId")
  val frameId: String,
  @field:JsonProperty("loaderId")
  val loaderId: String,
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("timestamp")
  val timestamp: Double,
)
