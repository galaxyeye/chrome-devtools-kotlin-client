package ai.platon.cdt.kt.protocol.types.overlay

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Configuration data for the highlighting of Flex container elements.
 */
data class FlexContainerHighlightConfig(
  @field:JsonProperty("containerBorder")
  @param:Optional
  val containerBorder: LineStyle? = null,
  @field:JsonProperty("lineSeparator")
  @param:Optional
  val lineSeparator: LineStyle? = null,
  @field:JsonProperty("itemSeparator")
  @param:Optional
  val itemSeparator: LineStyle? = null,
  @field:JsonProperty("mainDistributedSpace")
  @param:Optional
  val mainDistributedSpace: BoxStyle? = null,
  @field:JsonProperty("crossDistributedSpace")
  @param:Optional
  val crossDistributedSpace: BoxStyle? = null,
  @field:JsonProperty("rowGapSpace")
  @param:Optional
  val rowGapSpace: BoxStyle? = null,
  @field:JsonProperty("columnGapSpace")
  @param:Optional
  val columnGapSpace: BoxStyle? = null,
  @field:JsonProperty("crossAlignment")
  @param:Optional
  val crossAlignment: LineStyle? = null,
)
