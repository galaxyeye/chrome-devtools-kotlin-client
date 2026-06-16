@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.debugger

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.runtime.ExceptionDetails
import ai.platon.cdt.kt.protocol.types.runtime.StackTrace
import ai.platon.cdt.kt.protocol.types.runtime.StackTraceId
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.collections.List

data class SetScriptSource(
  @param:JsonProperty("callFrames")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val callFrames: List<CallFrame>? = null,
  @param:JsonProperty("stackChanged")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val stackChanged: Boolean? = null,
  @param:JsonProperty("asyncStackTrace")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val asyncStackTrace: StackTrace? = null,
  @param:JsonProperty("asyncStackTraceId")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val asyncStackTraceId: StackTraceId? = null,
  @param:JsonProperty("status")
  @param:Experimental
  val status: SetScriptSourceStatus,
  @param:JsonProperty("exceptionDetails")
  @param:Optional
  val exceptionDetails: ExceptionDetails? = null,
)
