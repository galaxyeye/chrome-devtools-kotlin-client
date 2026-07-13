@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.runtime.ExceptionDetails
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTrace
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTraceId
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SetScriptSource(
  @property:SerialName("callFrames")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val callFrames: List<CallFrame>? = null,
  @property:SerialName("stackChanged")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val stackChanged: Boolean? = null,
  @property:SerialName("asyncStackTrace")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val asyncStackTrace: StackTrace? = null,
  @property:SerialName("asyncStackTraceId")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val asyncStackTraceId: StackTraceId? = null,
  @property:SerialName("status")
  @param:Experimental
  val status: SetScriptSourceStatus,
  @property:SerialName("exceptionDetails")
  @param:Optional
  val exceptionDetails: ExceptionDetails? = null,
)
