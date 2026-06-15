@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.headlessexperimental
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Boolean
import kotlin.Deprecated

/**
 * Issued when the target starts or stops needing BeginFrames.
 * Deprecated. Issue beginFrame unconditionally instead and use result from
 * beginFrame to detect whether the frames were suppressed.
 */
@Deprecated("Deprecated")
@Serializable
data class NeedsBeginFramesChanged(
  @SerialName("needsBeginFrames")
  val needsBeginFrames: Boolean,
)
