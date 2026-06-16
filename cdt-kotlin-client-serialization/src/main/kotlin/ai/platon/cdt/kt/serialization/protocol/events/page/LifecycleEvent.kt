@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page

import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired for top level page lifecycle events such as navigation, load, paint, etc.
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
