package ai.platon.cdt.kt.protocol.types.layertree

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.dom.Rect
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Sticky position constraints.
 */
data class StickyPositionConstraint(
  @field:JsonProperty("stickyBoxRect")
  val stickyBoxRect: Rect,
  @field:JsonProperty("containingBlockRect")
  val containingBlockRect: Rect,
  @field:JsonProperty("nearestLayerShiftingStickyBox")
  @param:Optional
  val nearestLayerShiftingStickyBox: String? = null,
  @field:JsonProperty("nearestLayerShiftingContainingBlock")
  @param:Optional
  val nearestLayerShiftingContainingBlock: String? = null,
)
