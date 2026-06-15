@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.dom.Node
import kotlin.Int

/**
 * Mirrors `DOMNodeInserted` event.
 */
@Serializable
data class ChildNodeInserted(
  @SerialName("parentNodeId")
  val parentNodeId: Int,
  @SerialName("previousNodeId")
  val previousNodeId: Int,
  @SerialName("node")
  val node: Node,
)
