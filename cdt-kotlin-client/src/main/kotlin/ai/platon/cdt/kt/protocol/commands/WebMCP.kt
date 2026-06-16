@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.commands

import ai.platon.cdt.kt.protocol.events.webmcp.ToolInvoked
import ai.platon.cdt.kt.protocol.events.webmcp.ToolResponded
import ai.platon.cdt.kt.protocol.events.webmcp.ToolsAdded
import ai.platon.cdt.kt.protocol.events.webmcp.ToolsRemoved
import ai.platon.cdt.kt.protocol.support.annotations.EventName
import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.ParamName
import ai.platon.cdt.kt.protocol.support.annotations.Returns
import ai.platon.cdt.kt.protocol.support.types.EventHandler
import ai.platon.cdt.kt.protocol.support.types.EventListener
import kotlin.Any
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

@Experimental
interface WebMCP {
  /**
   * Enables the WebMCP domain, allowing events to be sent. Enabling the domain will trigger a toolsAdded event for
   * all currently registered tools.
   */
  suspend fun enable()

  /**
   * Disables the WebMCP domain.
   */
  suspend fun disable()

  /**
   * Invokes a registered tool.
   * @param frameId Frame in which to invoke the tool.
   * @param toolName Name of the tool to invoke.
   * @param input Input parameters for the tool, matching the tool's inputSchema.
   */
  @Returns("invocationId")
  suspend fun invokeTool(
    @ParamName("frameId") frameId: String,
    @ParamName("toolName") toolName: String,
    @ParamName("input") input: Map<String, Any?>,
  ): String

  /**
   * Cancels a pending tool invocation.
   * @param invocationId Invocation identifier to cancel.
   */
  suspend fun cancelInvocation(@ParamName("invocationId") invocationId: String)

  @EventName("toolsAdded")
  fun onToolsAdded(eventListener: EventHandler<ToolsAdded>): EventListener

  @EventName("toolsAdded")
  fun onToolsAdded(eventListener: suspend (ToolsAdded) -> Unit): EventListener

  @EventName("toolsRemoved")
  fun onToolsRemoved(eventListener: EventHandler<ToolsRemoved>): EventListener

  @EventName("toolsRemoved")
  fun onToolsRemoved(eventListener: suspend (ToolsRemoved) -> Unit): EventListener

  @EventName("toolInvoked")
  fun onToolInvoked(eventListener: EventHandler<ToolInvoked>): EventListener

  @EventName("toolInvoked")
  fun onToolInvoked(eventListener: suspend (ToolInvoked) -> Unit): EventListener

  @EventName("toolResponded")
  fun onToolResponded(eventListener: EventHandler<ToolResponded>): EventListener

  @EventName("toolResponded")
  fun onToolResponded(eventListener: suspend (ToolResponded) -> Unit): EventListener
}
