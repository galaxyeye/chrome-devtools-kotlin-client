@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.overlay
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int

/**
 * Fired when the node should be highlighted. This happens after call to `setInspectMode`.
 */
@Serializable
data class NodeHighlightRequested(
  @SerialName("nodeId")
  val nodeId: Int,
)
