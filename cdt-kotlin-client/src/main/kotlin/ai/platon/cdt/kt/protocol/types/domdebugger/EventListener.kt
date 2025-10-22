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
public data class EventListener(
  @field:JsonProperty("type")
  public val type: String,
  @field:JsonProperty("useCapture")
  public val useCapture: Boolean,
  @field:JsonProperty("passive")
  public val passive: Boolean,
  @field:JsonProperty("once")
  public val once: Boolean,
  @field:JsonProperty("scriptId")
  public val scriptId: String,
  @field:JsonProperty("lineNumber")
  public val lineNumber: Int,
  @field:JsonProperty("columnNumber")
  public val columnNumber: Int,
  @field:JsonProperty("handler")
  @param:Optional
  public val handler: RemoteObject? = null,
  @field:JsonProperty("originalHandler")
  @param:Optional
  public val originalHandler: RemoteObject? = null,
  @field:JsonProperty("backendNodeId")
  @param:Optional
  public val backendNodeId: Int? = null,
)
