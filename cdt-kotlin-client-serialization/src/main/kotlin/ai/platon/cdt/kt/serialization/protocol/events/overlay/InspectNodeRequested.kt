@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.overlay
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int

/**
 * Fired when the node should be inspected. This happens after call to `setInspectMode` or when
 * user manually inspects an element.
 */
@Serializable
data class InspectNodeRequested(
  @SerialName("backendNodeId")
  val backendNodeId: Int,
)
