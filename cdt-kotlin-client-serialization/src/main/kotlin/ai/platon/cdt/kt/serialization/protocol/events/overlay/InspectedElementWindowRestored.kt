@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.overlay

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when user asks to restore the Inspected Element floating window.
 */
@Serializable
data class InspectedElementWindowRestored(
  @property:SerialName("backendNodeId")
  val backendNodeId: Int,
)
