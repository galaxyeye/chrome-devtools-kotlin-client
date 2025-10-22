package ai.platon.cdt.kt.protocol.events.webaudio

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Notifies that an AudioNode is disconnected to an AudioParam.
 */
data class NodeParamDisconnected(
  @field:JsonProperty("contextId")
  val contextId: String,
  @field:JsonProperty("sourceId")
  val sourceId: String,
  @field:JsonProperty("destinationId")
  val destinationId: String,
  @field:JsonProperty("sourceOutputIndex")
  @param:Optional
  val sourceOutputIndex: Double? = null,
)
