@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.layertree
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.dom.Rect
import kotlin.String

/**
 * Sticky position constraints.
 */
@Serializable
data class StickyPositionConstraint(
  @SerialName("stickyBoxRect")
  val stickyBoxRect: Rect,
  @SerialName("containingBlockRect")
  val containingBlockRect: Rect,
  @SerialName("nearestLayerShiftingStickyBox")
  @param:Optional
  val nearestLayerShiftingStickyBox: String? = null,
  @SerialName("nearestLayerShiftingContainingBlock")
  @param:Optional
  val nearestLayerShiftingContainingBlock: String? = null,
)
