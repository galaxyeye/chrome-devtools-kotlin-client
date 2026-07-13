@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.accessibility

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.types.accessibility.AXNode
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

/**
 * The nodesUpdated event is sent every time a previously requested node has changed the in tree.
 */
@Experimental
data class NodesUpdated(
  @param:JsonProperty("nodes")
  val nodes: List<AXNode>,
)
