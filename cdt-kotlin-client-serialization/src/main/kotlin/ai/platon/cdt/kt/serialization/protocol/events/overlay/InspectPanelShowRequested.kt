@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.overlay

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when user asks to show the Inspect panel.
 */
@Serializable
data class InspectPanelShowRequested(
  @property:SerialName("backendNodeId")
  val backendNodeId: Int,
)
