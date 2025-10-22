package ai.platon.cdt.kt.protocol.types.domdebugger

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.runtime.RemoteObject
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Int
import kotlin.String

/**
 * Object event listener.
 */
data class EventListener(
  @field:JsonProperty("type")
  val type: String,
  @field:JsonProperty("useCapture")
  val useCapture: Boolean,
  @field:JsonProperty("passive")
  val passive: Boolean,
  @field:JsonProperty("once")
  val once: Boolean,
  @field:JsonProperty("scriptId")
  val scriptId: String,
  @field:JsonProperty("lineNumber")
  val lineNumber: Int,
  @field:JsonProperty("columnNumber")
  val columnNumber: Int,
  @field:JsonProperty("handler")
  @param:Optional
  val handler: RemoteObject? = null,
  @field:JsonProperty("originalHandler")
  @param:Optional
  val originalHandler: RemoteObject? = null,
  @field:JsonProperty("backendNodeId")
  @param:Optional
  val backendNodeId: Int? = null,
)
