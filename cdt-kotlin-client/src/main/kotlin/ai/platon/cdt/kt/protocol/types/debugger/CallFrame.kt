package ai.platon.cdt.kt.protocol.types.debugger

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.runtime.RemoteObject
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * JavaScript call frame. Array of call frames form the call stack.
 */
data class CallFrame(
  @field:JsonProperty("callFrameId")
  val callFrameId: String,
  @field:JsonProperty("functionName")
  val functionName: String,
  @field:JsonProperty("functionLocation")
  @param:Optional
  val functionLocation: Location? = null,
  @field:JsonProperty("location")
  val location: Location,
  @field:JsonProperty("url")
  val url: String,
  @field:JsonProperty("scopeChain")
  val scopeChain: List<Scope>,
  @field:JsonProperty("this")
  val `this`: RemoteObject,
  @field:JsonProperty("returnValue")
  @param:Optional
  val returnValue: RemoteObject? = null,
)
