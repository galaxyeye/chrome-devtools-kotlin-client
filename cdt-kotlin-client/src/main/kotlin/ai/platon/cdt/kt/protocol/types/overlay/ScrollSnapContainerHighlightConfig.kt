package ai.platon.cdt.kt.protocol.types.overlay

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.dom.RGBA
import com.fasterxml.jackson.`annotation`.JsonProperty

data class ScrollSnapContainerHighlightConfig(
  @field:JsonProperty("snapportBorder")
  @param:Optional
  val snapportBorder: LineStyle? = null,
  @field:JsonProperty("snapAreaBorder")
  @param:Optional
  val snapAreaBorder: LineStyle? = null,
  @field:JsonProperty("scrollMarginColor")
  @param:Optional
  val scrollMarginColor: RGBA? = null,
  @field:JsonProperty("scrollPaddingColor")
  @param:Optional
  val scrollPaddingColor: RGBA? = null,
)
