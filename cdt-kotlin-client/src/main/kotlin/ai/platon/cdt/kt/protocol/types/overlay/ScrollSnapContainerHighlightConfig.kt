package ai.platon.cdt.kt.protocol.types.overlay

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.dom.RGBA
import com.fasterxml.jackson.`annotation`.JsonProperty

public data class ScrollSnapContainerHighlightConfig(
  @field:JsonProperty("snapportBorder")
  @param:Optional
  public val snapportBorder: LineStyle? = null,
  @field:JsonProperty("snapAreaBorder")
  @param:Optional
  public val snapAreaBorder: LineStyle? = null,
  @field:JsonProperty("scrollMarginColor")
  @param:Optional
  public val scrollMarginColor: RGBA? = null,
  @field:JsonProperty("scrollPaddingColor")
  @param:Optional
  public val scrollPaddingColor: RGBA? = null,
)
