@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.page.Frame
import ai.platon.cdt.kt.serialization.protocol.types.page.NavigationType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired once navigation of the frame has completed. Frame is now associated with the new loader.
 */
@Serializable
data class FrameNavigated(
  @property:SerialName("frame")
  val frame: Frame,
  @property:SerialName("type")
  @param:Experimental
  val type: NavigationType,
)
