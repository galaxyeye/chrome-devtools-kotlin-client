package ai.platon.cdt.kt.protocol.types.dom

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Backend node with a friendly name.
 */
public data class BackendNode(
  @field:JsonProperty("nodeType")
  public val nodeType: Int,
  @field:JsonProperty("nodeName")
  public val nodeName: String,
  @field:JsonProperty("backendNodeId")
  public val backendNodeId: Int,
)
