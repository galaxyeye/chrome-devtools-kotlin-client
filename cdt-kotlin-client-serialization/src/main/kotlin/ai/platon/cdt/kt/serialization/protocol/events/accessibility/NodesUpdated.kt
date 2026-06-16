@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.accessibility

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.accessibility.AXNode
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The nodesUpdated event is sent every time a previously requested node has changed the in tree.
 */
@Serializable
@Experimental
data class NodesUpdated(
  @property:SerialName("nodes")
  val nodes: List<AXNode>,
)
