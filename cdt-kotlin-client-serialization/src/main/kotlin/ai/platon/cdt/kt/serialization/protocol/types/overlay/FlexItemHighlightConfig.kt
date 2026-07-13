@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Configuration data for the highlighting of Flex item elements.
 */
@Serializable
data class FlexItemHighlightConfig(
  @property:SerialName("baseSizeBox")
  @param:Optional
  val baseSizeBox: BoxStyle? = null,
  @property:SerialName("baseSizeBorder")
  @param:Optional
  val baseSizeBorder: LineStyle? = null,
  @property:SerialName("flexibilityArrow")
  @param:Optional
  val flexibilityArrow: LineStyle? = null,
)
