@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTrace
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTraceId
import kotlin.Deprecated
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestartFrame(
  @property:SerialName("callFrames")
  @Deprecated("Deprecated by protocol")
  val callFrames: List<CallFrame>,
  @property:SerialName("asyncStackTrace")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val asyncStackTrace: StackTrace? = null,
  @property:SerialName("asyncStackTraceId")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val asyncStackTraceId: StackTraceId? = null,
)
