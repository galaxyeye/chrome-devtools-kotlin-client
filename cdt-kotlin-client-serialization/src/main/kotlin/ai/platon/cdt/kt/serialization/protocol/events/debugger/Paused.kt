@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.debugger
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.debugger.CallFrame
import ai.platon.cdt.kt.serialization.protocol.types.debugger.PausedReason
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTrace
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTraceId
import kotlin.Any
import kotlin.Deprecated
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

/**
 * Fired when the virtual machine stopped on breakpoint or exception or any other stop criteria.
 */
@Serializable
data class Paused(
  @SerialName("callFrames")
  val callFrames: List<CallFrame>,
  @SerialName("reason")
  val reason: PausedReason,
  @SerialName("data")
  @param:Optional
  val `data`: Map<String, Any?>? = null,
  @SerialName("hitBreakpoints")
  @param:Optional
  val hitBreakpoints: List<String>? = null,
  @SerialName("asyncStackTrace")
  @param:Optional
  val asyncStackTrace: StackTrace? = null,
  @SerialName("asyncStackTraceId")
  @param:Optional
  @param:Experimental
  val asyncStackTraceId: StackTraceId? = null,
  @SerialName("asyncCallStackTraceId")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  @param:Experimental
  val asyncCallStackTraceId: StackTraceId? = null,
)
