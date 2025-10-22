package ai.platon.cdt.kt.protocol.events.webaudio

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Notifies that AudioNodes are disconnected. The destination can be null, and it means all the outgoing connections from the source are disconnected.
 */
data class NodesDisconnected(
  @field:JsonProperty("contextId")
  val contextId: String,
  @field:JsonProperty("sourceId")
  val sourceId: String,
  @field:JsonProperty("destinationId")
  val destinationId: String,
  @field:JsonProperty("sourceOutputIndex")
  @param:Optional
  val sourceOutputIndex: Double? = null,
  @field:JsonProperty("destinationInputIndex")
  @param:Optional
  val destinationInputIndex: Double? = null,
)
