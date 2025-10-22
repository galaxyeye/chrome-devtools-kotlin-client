package ai.platon.cdt.kt.protocol.types.debugger

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.runtime.ExceptionDetails
import ai.platon.cdt.kt.protocol.types.runtime.StackTrace
import ai.platon.cdt.kt.protocol.types.runtime.StackTraceId
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.collections.List

data class SetScriptSource(
  @field:JsonProperty("callFrames")
  @param:Optional
  val callFrames: List<CallFrame>? = null,
  @field:JsonProperty("stackChanged")
  @param:Optional
  val stackChanged: Boolean? = null,
  @field:JsonProperty("asyncStackTrace")
  @param:Optional
  val asyncStackTrace: StackTrace? = null,
  @field:JsonProperty("asyncStackTraceId")
  @param:Optional
  @param:Experimental
  val asyncStackTraceId: StackTraceId? = null,
  @field:JsonProperty("exceptionDetails")
  @param:Optional
  val exceptionDetails: ExceptionDetails? = null,
)
