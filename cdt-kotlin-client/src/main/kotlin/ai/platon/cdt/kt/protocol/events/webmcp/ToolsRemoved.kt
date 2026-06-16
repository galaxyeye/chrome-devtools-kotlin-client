@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.webmcp

import ai.platon.cdt.kt.protocol.types.webmcp.RemovedTool
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

/**
 * Event fired when tools are removed.
 */
data class ToolsRemoved(
  @param:JsonProperty("tools")
  val tools: List<RemovedTool>,
)
