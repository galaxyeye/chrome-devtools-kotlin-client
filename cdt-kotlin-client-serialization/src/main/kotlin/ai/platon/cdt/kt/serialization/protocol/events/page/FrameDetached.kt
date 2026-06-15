@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.page.FrameDetachedReason
import kotlin.String

/**
 * Fired when frame has been detached from its parent.
 */
@Serializable
data class FrameDetached(
  @SerialName("frameId")
  val frameId: String,
  @SerialName("reason")
  @param:Experimental
  val reason: FrameDetachedReason,
)
