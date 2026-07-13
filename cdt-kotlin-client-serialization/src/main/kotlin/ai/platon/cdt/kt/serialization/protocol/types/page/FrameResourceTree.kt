@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Information about the Frame hierarchy along with their cached resources.
 */
@Serializable
@Experimental
data class FrameResourceTree(
  @property:SerialName("frame")
  val frame: Frame,
  @property:SerialName("childFrames")
  @param:Optional
  val childFrames: List<FrameResourceTree>? = null,
  @property:SerialName("resources")
  val resources: List<FrameResource>,
)
