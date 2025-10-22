package ai.platon.cdt.kt.protocol.events.debugger

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.debugger.CallFrame
import ai.platon.cdt.kt.protocol.types.debugger.PausedReason
import ai.platon.cdt.kt.protocol.types.runtime.StackTrace
import ai.platon.cdt.kt.protocol.types.runtime.StackTraceId
import com.fasterxml.jackson.`annotation`.JsonProperty
import java.lang.Deprecated
import kotlin.Any
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

/**
 * Fired when the virtual machine stopped on breakpoint or exception or any other stop criteria.
 */
data class Paused(
  @field:JsonProperty("callFrames")
  val callFrames: List<CallFrame>,
  @field:JsonProperty("reason")
  val reason: PausedReason,
  @field:JsonProperty("data")
  @param:Optional
  val `data`: Map<String, Any?>? = null,
  @field:JsonProperty("hitBreakpoints")
  @param:Optional
  val hitBreakpoints: List<String>? = null,
  @field:JsonProperty("asyncStackTrace")
  @param:Optional
  val asyncStackTrace: StackTrace? = null,
  @field:JsonProperty("asyncStackTraceId")
  @param:Optional
  @param:Experimental
  val asyncStackTraceId: StackTraceId? = null,
  @field:JsonProperty("asyncCallStackTraceId")
  @param:Optional
  @param:Deprecated
  @param:Experimental
  val asyncCallStackTraceId: StackTraceId? = null,
)
