package ai.platon.cdt.kt.protocol.events.dom

import ai.platon.cdt.kt.protocol.types.dom.Node
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.collections.List

/**
 * Fired when backend wants to provide client with the missing DOM structure. This happens upon
 * most of the calls requesting node ids.
 */
data class SetChildNodes(
  @field:JsonProperty("parentId")
  val parentId: Int,
  @field:JsonProperty("nodes")
  val nodes: List<Node>,
)
