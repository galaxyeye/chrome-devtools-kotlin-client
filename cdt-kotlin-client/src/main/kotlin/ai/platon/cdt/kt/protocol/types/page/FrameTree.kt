package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

/**
 * Information about the Frame hierarchy.
 */
data class FrameTree(
  @field:JsonProperty("frame")
  val frame: Frame,
  @field:JsonProperty("childFrames")
  @param:Optional
  val childFrames: List<FrameTree>? = null,
)
