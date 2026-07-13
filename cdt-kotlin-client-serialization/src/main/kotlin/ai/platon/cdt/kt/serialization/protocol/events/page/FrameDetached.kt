@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.page.FrameDetachedReason
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when frame has been detached from its parent.
 */
@Serializable
data class FrameDetached(
  @property:SerialName("frameId")
  val frameId: String,
  @property:SerialName("reason")
  @param:Experimental
  val reason: FrameDetachedReason,
)
