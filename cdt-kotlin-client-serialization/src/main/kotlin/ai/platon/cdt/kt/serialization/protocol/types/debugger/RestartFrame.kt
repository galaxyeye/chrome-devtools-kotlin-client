@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTrace
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTraceId
import kotlin.collections.List

@Serializable
data class RestartFrame(
  @SerialName("callFrames")
  val callFrames: List<CallFrame>,
  @SerialName("asyncStackTrace")
  @param:Optional
  val asyncStackTrace: StackTrace? = null,
  @SerialName("asyncStackTraceId")
  @param:Optional
  @param:Experimental
  val asyncStackTraceId: StackTraceId? = null,
)
