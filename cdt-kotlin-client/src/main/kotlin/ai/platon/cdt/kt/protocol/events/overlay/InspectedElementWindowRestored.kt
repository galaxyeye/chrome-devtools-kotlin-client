@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.overlay

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Fired when user asks to restore the Inspected Element floating window.
 */
data class InspectedElementWindowRestored(
  @param:JsonProperty("backendNodeId")
  val backendNodeId: Int,
)
