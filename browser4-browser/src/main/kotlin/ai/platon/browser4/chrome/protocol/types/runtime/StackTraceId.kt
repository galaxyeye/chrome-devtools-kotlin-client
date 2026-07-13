@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.runtime

import ai.platon.browser4.chrome.protocol.support.annotations.Experimental
import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * If `debuggerId` is set stack trace comes from another debugger and can be resolved there. This
 * allows to track cross-debugger calls. See `Runtime.StackTrace` and `Debugger.paused` for usages.
 */
@Serializable
@Experimental
data class StackTraceId(
  @property:SerialName("id")
  val id: String,
  @property:SerialName("debuggerId")
  @param:Optional
  val debuggerId: String? = null,
)
