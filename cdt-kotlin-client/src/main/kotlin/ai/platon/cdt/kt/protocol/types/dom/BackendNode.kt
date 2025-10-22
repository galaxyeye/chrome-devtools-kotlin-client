package ai.platon.cdt.kt.protocol.types.dom

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Backend node with a friendly name.
 */
data class BackendNode(
  @field:JsonProperty("nodeType")
  val nodeType: Int,
  @field:JsonProperty("nodeName")
  val nodeName: String,
  @field:JsonProperty("backendNodeId")
  val backendNodeId: Int,
)
