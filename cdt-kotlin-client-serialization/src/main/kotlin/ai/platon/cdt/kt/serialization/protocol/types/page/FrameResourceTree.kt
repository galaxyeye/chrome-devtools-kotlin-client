@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.collections.List

/**
 * Information about the Frame hierarchy along with their cached resources.
 */
@Experimental
@Serializable
data class FrameResourceTree(
  @SerialName("frame")
  val frame: Frame,
  @SerialName("childFrames")
  @param:Optional
  val childFrames: List<FrameResourceTree>? = null,
  @SerialName("resources")
  val resources: List<FrameResource>,
)
