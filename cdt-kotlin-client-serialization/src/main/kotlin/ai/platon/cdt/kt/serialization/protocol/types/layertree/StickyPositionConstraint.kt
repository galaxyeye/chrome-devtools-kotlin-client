@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.layertree

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.dom.Rect
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Sticky position constraints.
 */
@Serializable
data class StickyPositionConstraint(
  @property:SerialName("stickyBoxRect")
  val stickyBoxRect: Rect,
  @property:SerialName("containingBlockRect")
  val containingBlockRect: Rect,
  @property:SerialName("nearestLayerShiftingStickyBox")
  @param:Optional
  val nearestLayerShiftingStickyBox: String? = null,
  @property:SerialName("nearestLayerShiftingContainingBlock")
  @param:Optional
  val nearestLayerShiftingContainingBlock: String? = null,
)
