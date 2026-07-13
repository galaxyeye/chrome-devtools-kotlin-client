@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.overlay

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Fired when user asks to show the Inspect panel.
 */
data class InspectPanelShowRequested(
  @param:JsonProperty("backendNodeId")
  val backendNodeId: Int,
)
