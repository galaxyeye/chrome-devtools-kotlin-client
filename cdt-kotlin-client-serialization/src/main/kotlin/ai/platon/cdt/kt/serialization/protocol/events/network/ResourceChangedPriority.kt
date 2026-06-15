@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.network.ResourcePriority
import kotlin.Double
import kotlin.String

/**
 * Fired when resource loading priority is changed
 */
@Experimental
@Serializable
data class ResourceChangedPriority(
  @SerialName("requestId")
  val requestId: String,
  @SerialName("newPriority")
  val newPriority: ResourcePriority,
  @SerialName("timestamp")
  val timestamp: Double,
)
