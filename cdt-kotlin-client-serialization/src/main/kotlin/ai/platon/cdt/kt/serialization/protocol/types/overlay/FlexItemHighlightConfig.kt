@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional

/**
 * Configuration data for the highlighting of Flex item elements.
 */
@Serializable
data class FlexItemHighlightConfig(
  @SerialName("baseSizeBox")
  @param:Optional
  val baseSizeBox: BoxStyle? = null,
  @SerialName("baseSizeBorder")
  @param:Optional
  val baseSizeBorder: LineStyle? = null,
  @SerialName("flexibilityArrow")
  @param:Optional
  val flexibilityArrow: LineStyle? = null,
)
