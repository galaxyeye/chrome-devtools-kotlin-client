@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.webmcp

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.runtime.RemoteObject
import ai.platon.cdt.kt.protocol.types.webmcp.InvocationStatus
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.String

/**
 * Event fired when a tool invocation completes or fails.
 */
data class ToolResponded(
  @param:JsonProperty("invocationId")
  val invocationId: String,
  @param:JsonProperty("status")
  val status: InvocationStatus,
  @param:JsonProperty("output")
  @param:Optional
  val output: Any? = null,
  @param:JsonProperty("errorText")
  @param:Optional
  val errorText: String? = null,
  @param:JsonProperty("exception")
  @param:Optional
  val exception: RemoteObject? = null,
)
