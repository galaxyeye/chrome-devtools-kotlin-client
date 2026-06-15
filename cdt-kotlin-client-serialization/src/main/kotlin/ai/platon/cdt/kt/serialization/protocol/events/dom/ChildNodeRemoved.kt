@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int

/**
 * Mirrors `DOMNodeRemoved` event.
 */
@Serializable
data class ChildNodeRemoved(
  @SerialName("parentNodeId")
  val parentNodeId: Int,
  @SerialName("nodeId")
  val nodeId: Int,
)
