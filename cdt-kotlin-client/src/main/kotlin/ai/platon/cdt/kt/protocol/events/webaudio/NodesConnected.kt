package ai.platon.cdt.kt.protocol.events.webaudio

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Notifies that two AudioNodes are connected.
 */
public data class NodesConnected(
  @field:JsonProperty("contextId")
  public val contextId: String,
  @field:JsonProperty("sourceId")
  public val sourceId: String,
  @field:JsonProperty("destinationId")
  public val destinationId: String,
  @field:JsonProperty("sourceOutputIndex")
  @param:Optional
  public val sourceOutputIndex: Double? = null,
  @field:JsonProperty("destinationInputIndex")
  @param:Optional
  public val destinationInputIndex: Double? = null,
)
