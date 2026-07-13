@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.overlay

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when the node should be highlighted. This happens after call to `setInspectMode`.
 */
@Serializable
data class NodeHighlightRequested(
  @property:SerialName("nodeId")
  val nodeId: Int,
)
