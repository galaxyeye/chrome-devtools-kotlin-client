@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page

import kotlin.Double
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoadEventFired(
  @property:SerialName("timestamp")
  val timestamp: Double,
)
