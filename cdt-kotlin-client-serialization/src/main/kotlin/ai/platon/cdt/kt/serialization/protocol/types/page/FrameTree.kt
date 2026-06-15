@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.collections.List

/**
 * Information about the Frame hierarchy.
 */
@Serializable
data class FrameTree(
  @SerialName("frame")
  val frame: Frame,
  @SerialName("childFrames")
  @param:Optional
  val childFrames: List<FrameTree>? = null,
)
