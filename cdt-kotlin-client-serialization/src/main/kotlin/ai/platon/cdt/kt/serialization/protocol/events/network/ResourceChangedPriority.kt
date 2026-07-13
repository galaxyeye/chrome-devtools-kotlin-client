@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.network.ResourcePriority
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when resource loading priority is changed
 */
@Serializable
@Experimental
data class ResourceChangedPriority(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("newPriority")
  val newPriority: ResourcePriority,
  @property:SerialName("timestamp")
  val timestamp: Double,
)
