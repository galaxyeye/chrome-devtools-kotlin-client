@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webmcp

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.runtime.RemoteObject
import ai.platon.cdt.kt.serialization.protocol.types.webmcp.InvocationStatus
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

/**
 * Event fired when a tool invocation completes or fails.
 */
@Serializable
data class ToolResponded(
  @property:SerialName("invocationId")
  val invocationId: String,
  @property:SerialName("status")
  val status: InvocationStatus,
  @property:SerialName("output")
  @param:Optional
  val output: JsonElement? = null,
  @property:SerialName("errorText")
  @param:Optional
  val errorText: String? = null,
  @property:SerialName("exception")
  @param:Optional
  val exception: RemoteObject? = null,
)
