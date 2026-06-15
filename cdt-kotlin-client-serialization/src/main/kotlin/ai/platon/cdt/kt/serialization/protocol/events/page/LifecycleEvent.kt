@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.String

/**
 * Fired for top level page lifecycle events such as navigation, load, paint, etc.
 */
@Serializable
data class LifecycleEvent(
  @SerialName("frameId")
  val frameId: String,
  @SerialName("loaderId")
  val loaderId: String,
  @SerialName("name")
  val name: String,
  @SerialName("timestamp")
  val timestamp: Double,
)
