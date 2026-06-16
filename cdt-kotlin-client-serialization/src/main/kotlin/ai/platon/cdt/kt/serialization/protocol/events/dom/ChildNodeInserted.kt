@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom

import ai.platon.cdt.kt.serialization.protocol.types.dom.Node
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Mirrors `DOMNodeInserted` event.
 */
@Serializable
data class ChildNodeInserted(
  @property:SerialName("parentNodeId")
  val parentNodeId: Int,
  @property:SerialName("previousNodeId")
  val previousNodeId: Int,
  @property:SerialName("node")
  val node: Node,
)
