package ai.platon.cdt.kt.protocol.types.debugger

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.runtime.StackTrace
import ai.platon.cdt.kt.protocol.types.runtime.StackTraceId
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

public data class RestartFrame(
  @field:JsonProperty("callFrames")
  public val callFrames: List<CallFrame>,
  @field:JsonProperty("asyncStackTrace")
  @param:Optional
  public val asyncStackTrace: StackTrace? = null,
  @field:JsonProperty("asyncStackTraceId")
  @param:Optional
  @param:Experimental
  public val asyncStackTraceId: StackTraceId? = null,
)
