@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.page

import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Information about the Frame hierarchy.
 */
@Serializable
data class FrameTree(
  @property:SerialName("frame")
  val frame: Frame,
  @property:SerialName("childFrames")
  @param:Optional
  val childFrames: List<FrameTree>? = null,
) {
  companion object {
    /** Fallback instance used when CDP deserialization fails due to protocol mismatch. */
    fun degraded(): FrameTree = FrameTree(frame = Frame.degraded())
  }
}
