package ai.platon.cdt.kt.protocol.events.dom

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Mirrors `DOMNodeRemoved` event.
 */
data class ChildNodeRemoved(
  @field:JsonProperty("parentNodeId")
  val parentNodeId: Int,
  @field:JsonProperty("nodeId")
  val nodeId: Int,
)
