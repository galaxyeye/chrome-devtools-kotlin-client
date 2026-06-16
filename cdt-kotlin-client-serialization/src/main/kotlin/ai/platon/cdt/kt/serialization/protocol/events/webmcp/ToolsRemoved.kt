@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webmcp

import ai.platon.cdt.kt.serialization.protocol.types.webmcp.RemovedTool
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Event fired when tools are removed.
 */
@Serializable
data class ToolsRemoved(
  @property:SerialName("tools")
  val tools: List<RemovedTool>,
)
