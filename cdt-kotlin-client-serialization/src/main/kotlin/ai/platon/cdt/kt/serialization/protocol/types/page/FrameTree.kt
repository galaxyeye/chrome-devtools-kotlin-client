@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
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
)
