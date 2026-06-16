@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.page

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Fired for lifecycle events (navigation, load, paint, etc) in the current
 * target (including local frames).
 */
data class LifecycleEvent(
  @param:JsonProperty("frameId")
  val frameId: String,
  @param:JsonProperty("loaderId")
  val loaderId: String,
  @param:JsonProperty("name")
  val name: String,
  @param:JsonProperty("timestamp")
  val timestamp: Double,
)
