package ai.platon.cdt.kt.protocol.types.overlay

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Configuration data for the highlighting of Flex container elements.
 */
public data class FlexContainerHighlightConfig(
  @field:JsonProperty("containerBorder")
  @param:Optional
  public val containerBorder: LineStyle? = null,
  @field:JsonProperty("lineSeparator")
  @param:Optional
  public val lineSeparator: LineStyle? = null,
  @field:JsonProperty("itemSeparator")
  @param:Optional
  public val itemSeparator: LineStyle? = null,
  @field:JsonProperty("mainDistributedSpace")
  @param:Optional
  public val mainDistributedSpace: BoxStyle? = null,
  @field:JsonProperty("crossDistributedSpace")
  @param:Optional
  public val crossDistributedSpace: BoxStyle? = null,
  @field:JsonProperty("rowGapSpace")
  @param:Optional
  public val rowGapSpace: BoxStyle? = null,
  @field:JsonProperty("columnGapSpace")
  @param:Optional
  public val columnGapSpace: BoxStyle? = null,
  @field:JsonProperty("crossAlignment")
  @param:Optional
  public val crossAlignment: LineStyle? = null,
)
