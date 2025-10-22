package ai.platon.cdt.kt.protocol.types.overlay

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Configuration data for the highlighting of Flex item elements.
 */
public data class FlexItemHighlightConfig(
  @field:JsonProperty("baseSizeBox")
  @param:Optional
  public val baseSizeBox: BoxStyle? = null,
  @field:JsonProperty("baseSizeBorder")
  @param:Optional
  public val baseSizeBorder: LineStyle? = null,
  @field:JsonProperty("flexibilityArrow")
  @param:Optional
  public val flexibilityArrow: LineStyle? = null,
)
