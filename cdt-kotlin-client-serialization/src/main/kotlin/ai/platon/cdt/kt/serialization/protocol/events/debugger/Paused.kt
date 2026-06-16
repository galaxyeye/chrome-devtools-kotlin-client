@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.debugger

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.debugger.CallFrame
import ai.platon.cdt.kt.serialization.protocol.types.debugger.PausedReason
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTrace
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTraceId
import kotlin.Deprecated
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

/**
 * Fired when the virtual machine stopped on breakpoint or exception or any other stop criteria.
 */
@Serializable
data class Paused(
  @property:SerialName("callFrames")
  val callFrames: List<CallFrame>,
  @property:SerialName("reason")
  val reason: PausedReason,
  @property:SerialName("data")
  @param:Optional
  val `data`: JsonObject? = null,
  @property:SerialName("hitBreakpoints")
  @param:Optional
  val hitBreakpoints: List<String>? = null,
  @property:SerialName("asyncStackTrace")
  @param:Optional
  val asyncStackTrace: StackTrace? = null,
  @property:SerialName("asyncStackTraceId")
  @param:Optional
  @param:Experimental
  val asyncStackTraceId: StackTraceId? = null,
  @property:SerialName("asyncCallStackTraceId")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  @param:Experimental
  val asyncCallStackTraceId: StackTraceId? = null,
)
