package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

/**
 * Information about the Frame hierarchy along with their cached resources.
 */
@Experimental
public data class FrameResourceTree(
  @field:JsonProperty("frame")
  public val frame: Frame,
  @field:JsonProperty("childFrames")
  @param:Optional
  public val childFrames: List<FrameResourceTree>? = null,
  @field:JsonProperty("resources")
  public val resources: List<FrameResource>,
)
