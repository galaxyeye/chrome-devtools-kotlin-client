package ai.platon.cdt.kt.protocol.events.webaudio

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Notifies that an AudioNode is connected to an AudioParam.
 */
public data class NodeParamConnected(
  @field:JsonProperty("contextId")
  public val contextId: String,
  @field:JsonProperty("sourceId")
  public val sourceId: String,
  @field:JsonProperty("destinationId")
  public val destinationId: String,
  @field:JsonProperty("sourceOutputIndex")
  @param:Optional
  public val sourceOutputIndex: Double? = null,
)
