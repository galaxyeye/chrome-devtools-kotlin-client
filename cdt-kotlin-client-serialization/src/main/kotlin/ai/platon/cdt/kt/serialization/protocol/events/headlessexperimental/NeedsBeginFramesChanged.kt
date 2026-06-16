@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.headlessexperimental

import kotlin.Boolean
import kotlin.Deprecated
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Issued when the target starts or stops needing BeginFrames.
 * Deprecated. Issue beginFrame unconditionally instead and use result from
 * beginFrame to detect whether the frames were suppressed.
 */
@Serializable
@Deprecated("Deprecated")
data class NeedsBeginFramesChanged(
  @property:SerialName("needsBeginFrames")
  val needsBeginFrames: Boolean,
)
