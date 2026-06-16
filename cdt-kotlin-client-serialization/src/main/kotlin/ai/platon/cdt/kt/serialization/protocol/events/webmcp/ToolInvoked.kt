@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webmcp

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Event fired when a tool invocation starts.
 */
@Serializable
data class ToolInvoked(
  @property:SerialName("toolName")
  val toolName: String,
  @property:SerialName("frameId")
  val frameId: String,
  @property:SerialName("invocationId")
  val invocationId: String,
  @property:SerialName("input")
  val input: String,
)
