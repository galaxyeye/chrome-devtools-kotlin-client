package ai.platon.cdt.kt.protocol.types.overlay

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.dom.RGBA
import com.fasterxml.jackson.`annotation`.JsonProperty
import java.lang.Deprecated
import kotlin.Boolean

/**
 * Configuration data for the highlighting of Grid elements.
 */
public data class GridHighlightConfig(
  @field:JsonProperty("showGridExtensionLines")
  @param:Optional
  public val showGridExtensionLines: Boolean? = null,
  @field:JsonProperty("showPositiveLineNumbers")
  @param:Optional
  public val showPositiveLineNumbers: Boolean? = null,
  @field:JsonProperty("showNegativeLineNumbers")
  @param:Optional
  public val showNegativeLineNumbers: Boolean? = null,
  @field:JsonProperty("showAreaNames")
  @param:Optional
  public val showAreaNames: Boolean? = null,
  @field:JsonProperty("showLineNames")
  @param:Optional
  public val showLineNames: Boolean? = null,
  @field:JsonProperty("showTrackSizes")
  @param:Optional
  public val showTrackSizes: Boolean? = null,
  @field:JsonProperty("gridBorderColor")
  @param:Optional
  public val gridBorderColor: RGBA? = null,
  @field:JsonProperty("cellBorderColor")
  @param:Optional
  @param:Deprecated
  public val cellBorderColor: RGBA? = null,
  @field:JsonProperty("rowLineColor")
  @param:Optional
  public val rowLineColor: RGBA? = null,
  @field:JsonProperty("columnLineColor")
  @param:Optional
  public val columnLineColor: RGBA? = null,
  @field:JsonProperty("gridBorderDash")
  @param:Optional
  public val gridBorderDash: Boolean? = null,
  @field:JsonProperty("cellBorderDash")
  @param:Optional
  @param:Deprecated
  public val cellBorderDash: Boolean? = null,
  @field:JsonProperty("rowLineDash")
  @param:Optional
  public val rowLineDash: Boolean? = null,
  @field:JsonProperty("columnLineDash")
  @param:Optional
  public val columnLineDash: Boolean? = null,
  @field:JsonProperty("rowGapColor")
  @param:Optional
  public val rowGapColor: RGBA? = null,
  @field:JsonProperty("rowHatchColor")
  @param:Optional
  public val rowHatchColor: RGBA? = null,
  @field:JsonProperty("columnGapColor")
  @param:Optional
  public val columnGapColor: RGBA? = null,
  @field:JsonProperty("columnHatchColor")
  @param:Optional
  public val columnHatchColor: RGBA? = null,
  @field:JsonProperty("areaBorderColor")
  @param:Optional
  public val areaBorderColor: RGBA? = null,
  @field:JsonProperty("gridBackgroundColor")
  @param:Optional
  public val gridBackgroundColor: RGBA? = null,
)
