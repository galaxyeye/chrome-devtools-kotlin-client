@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.webmcp

import ai.platon.cdt.kt.protocol.types.webmcp.Tool
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

/**
 * Event fired when new tools are added.
 */
data class ToolsAdded(
  @param:JsonProperty("tools")
  val tools: List<Tool>,
)
