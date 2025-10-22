package ai.platon.cdt.kt.protocol.types.dom

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

public data class NodeForLocation(
  @field:JsonProperty("backendNodeId")
  public val backendNodeId: Int,
  @field:JsonProperty("frameId")
  public val frameId: String,
  @field:JsonProperty("nodeId")
  @param:Optional
  public val nodeId: Int? = null,
)
