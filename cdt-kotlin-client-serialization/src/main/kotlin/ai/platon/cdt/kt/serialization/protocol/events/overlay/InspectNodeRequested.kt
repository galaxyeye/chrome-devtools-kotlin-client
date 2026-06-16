@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.overlay

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when the node should be inspected. This happens after call to `setInspectMode` or when
 * user manually inspects an element.
 */
@Serializable
data class InspectNodeRequested(
  @property:SerialName("backendNodeId")
  val backendNodeId: Int,
)
