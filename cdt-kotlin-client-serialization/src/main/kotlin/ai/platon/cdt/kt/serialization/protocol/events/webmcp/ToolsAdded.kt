@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webmcp

import ai.platon.cdt.kt.serialization.protocol.types.webmcp.Tool
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Event fired when new tools are added.
 */
@Serializable
data class ToolsAdded(
  @property:SerialName("tools")
  val tools: List<Tool>,
)
