@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.webmcp

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Event fired when a tool invocation starts.
 */
data class ToolInvoked(
  @param:JsonProperty("toolName")
  val toolName: String,
  @param:JsonProperty("frameId")
  val frameId: String,
  @param:JsonProperty("invocationId")
  val invocationId: String,
  @param:JsonProperty("input")
  val input: String,
)
