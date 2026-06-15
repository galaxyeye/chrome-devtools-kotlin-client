@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double

@Serializable
data class DomContentEventFired(
  @SerialName("timestamp")
  val timestamp: Double,
)
