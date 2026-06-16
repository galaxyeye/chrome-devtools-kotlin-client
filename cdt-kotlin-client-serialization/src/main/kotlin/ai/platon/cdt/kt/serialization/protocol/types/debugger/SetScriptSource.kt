@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.runtime.ExceptionDetails
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTrace
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTraceId
import kotlin.Boolean
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SetScriptSource(
  @property:SerialName("callFrames")
  @param:Optional
  val callFrames: List<CallFrame>? = null,
  @property:SerialName("stackChanged")
  @param:Optional
  val stackChanged: Boolean? = null,
  @property:SerialName("asyncStackTrace")
  @param:Optional
  val asyncStackTrace: StackTrace? = null,
  @property:SerialName("asyncStackTraceId")
  @param:Optional
  @param:Experimental
  val asyncStackTraceId: StackTraceId? = null,
  @property:SerialName("exceptionDetails")
  @param:Optional
  val exceptionDetails: ExceptionDetails? = null,
)
