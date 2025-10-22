package ai.platon.cdt.kt.protocol.types.overlay

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Configuration data for the highlighting of Flex item elements.
 */
data class FlexItemHighlightConfig(
  @field:JsonProperty("baseSizeBox")
  @param:Optional
  val baseSizeBox: BoxStyle? = null,
  @field:JsonProperty("baseSizeBorder")
  @param:Optional
  val baseSizeBorder: LineStyle? = null,
  @field:JsonProperty("flexibilityArrow")
  @param:Optional
  val flexibilityArrow: LineStyle? = null,
)
