@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom

import ai.platon.cdt.kt.serialization.protocol.types.dom.Node
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when backend wants to provide client with the missing DOM structure. This happens upon
 * most of the calls requesting node ids.
 */
@Serializable
data class SetChildNodes(
  @property:SerialName("parentId")
  val parentId: Int,
  @property:SerialName("nodes")
  val nodes: List<Node>,
)
