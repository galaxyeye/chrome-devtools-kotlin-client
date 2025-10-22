package ai.platon.cdt.kt.protocol.types.debugger

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.runtime.RemoteObject
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * JavaScript call frame. Array of call frames form the call stack.
 */
public data class CallFrame(
  @field:JsonProperty("callFrameId")
  public val callFrameId: String,
  @field:JsonProperty("functionName")
  public val functionName: String,
  @field:JsonProperty("functionLocation")
  @param:Optional
  public val functionLocation: Location? = null,
  @field:JsonProperty("location")
  public val location: Location,
  @field:JsonProperty("url")
  public val url: String,
  @field:JsonProperty("scopeChain")
  public val scopeChain: List<Scope>,
  @field:JsonProperty("this")
  public val `this`: RemoteObject,
  @field:JsonProperty("returnValue")
  @param:Optional
  public val returnValue: RemoteObject? = null,
)
