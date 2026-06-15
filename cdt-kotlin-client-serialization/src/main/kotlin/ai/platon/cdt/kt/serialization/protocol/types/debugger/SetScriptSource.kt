@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.runtime.ExceptionDetails
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTrace
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTraceId
import kotlin.Boolean
import kotlin.collections.List

@Serializable
data class SetScriptSource(
  @SerialName("callFrames")
  @param:Optional
  val callFrames: List<CallFrame>? = null,
  @SerialName("stackChanged")
  @param:Optional
  val stackChanged: Boolean? = null,
  @SerialName("asyncStackTrace")
  @param:Optional
  val asyncStackTrace: StackTrace? = null,
  @SerialName("asyncStackTraceId")
  @param:Optional
  @param:Experimental
  val asyncStackTraceId: StackTraceId? = null,
  @SerialName("exceptionDetails")
  @param:Optional
  val exceptionDetails: ExceptionDetails? = null,
)
