@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page

import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired for lifecycle events (navigation, load, paint, etc) in the current
 * target (including local frames).
 */
@Serializable
data class LifecycleEvent(
  @property:SerialName("frameId")
  val frameId: String,
  @property:SerialName("loaderId")
  val loaderId: String,
  @property:SerialName("name")
  val name: String,
  @property:SerialName("timestamp")
  val timestamp: Double,
)
