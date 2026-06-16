@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired before frame subtree is detached. Emitted before any frame of the
 * subtree is actually detached.
 */
@Serializable
@Experimental
data class FrameSubtreeWillBeDetached(
  @property:SerialName("frameId")
  val frameId: String,
)
