package ai.platon.cdt.kt.protocol.events.dom

import ai.platon.cdt.kt.protocol.types.dom.Node
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Mirrors `DOMNodeInserted` event.
 */
data class ChildNodeInserted(
  @field:JsonProperty("parentNodeId")
  val parentNodeId: Int,
  @field:JsonProperty("previousNodeId")
  val previousNodeId: Int,
  @field:JsonProperty("node")
  val node: Node,
)
