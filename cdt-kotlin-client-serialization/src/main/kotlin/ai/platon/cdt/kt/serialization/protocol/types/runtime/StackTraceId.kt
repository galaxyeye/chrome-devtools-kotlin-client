@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String

/**
 * If `debuggerId` is set stack trace comes from another debugger and can be resolved there. This
 * allows to track cross-debugger calls. See `Runtime.StackTrace` and `Debugger.paused` for usages.
 */
@Experimental
@Serializable
data class StackTraceId(
  @SerialName("id")
  val id: String,
  @SerialName("debuggerId")
  @param:Optional
  val debuggerId: String? = null,
)
