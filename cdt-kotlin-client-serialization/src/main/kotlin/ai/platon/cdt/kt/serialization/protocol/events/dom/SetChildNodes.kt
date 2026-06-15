@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.dom.Node
import kotlin.Int
import kotlin.collections.List

/**
 * Fired when backend wants to provide client with the missing DOM structure. This happens upon
 * most of the calls requesting node ids.
 */
@Serializable
data class SetChildNodes(
  @SerialName("parentId")
  val parentId: Int,
  @SerialName("nodes")
  val nodes: List<Node>,
)
