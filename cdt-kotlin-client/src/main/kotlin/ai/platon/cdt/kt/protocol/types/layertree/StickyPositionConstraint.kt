package ai.platon.cdt.kt.protocol.types.layertree

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.dom.Rect
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Sticky position constraints.
 */
public data class StickyPositionConstraint(
  @field:JsonProperty("stickyBoxRect")
  public val stickyBoxRect: Rect,
  @field:JsonProperty("containingBlockRect")
  public val containingBlockRect: Rect,
  @field:JsonProperty("nearestLayerShiftingStickyBox")
  @param:Optional
  public val nearestLayerShiftingStickyBox: String? = null,
  @field:JsonProperty("nearestLayerShiftingContainingBlock")
  @param:Optional
  public val nearestLayerShiftingContainingBlock: String? = null,
)
