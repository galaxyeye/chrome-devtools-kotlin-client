@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Mirrors `DOMNodeRemoved` event.
 */
@Serializable
data class ChildNodeRemoved(
  @property:SerialName("parentNodeId")
  val parentNodeId: Int,
  @property:SerialName("nodeId")
  val nodeId: Int,
)
