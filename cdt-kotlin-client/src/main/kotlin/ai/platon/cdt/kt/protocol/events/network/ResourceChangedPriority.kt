package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.types.network.ResourcePriority
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Fired when resource loading priority is changed
 */
@Experimental
data class ResourceChangedPriority(
  @field:JsonProperty("requestId")
  val requestId: String,
  @field:JsonProperty("newPriority")
  val newPriority: ResourcePriority,
  @field:JsonProperty("timestamp")
  val timestamp: Double,
)
