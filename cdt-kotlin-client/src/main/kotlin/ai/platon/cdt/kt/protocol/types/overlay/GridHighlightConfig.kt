package ai.platon.cdt.kt.protocol.types.overlay

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.dom.RGBA
import com.fasterxml.jackson.`annotation`.JsonProperty
import java.lang.Deprecated
import kotlin.Boolean

/**
 * Configuration data for the highlighting of Grid elements.
 */
data class GridHighlightConfig(
  @field:JsonProperty("showGridExtensionLines")
  @param:Optional
  val showGridExtensionLines: Boolean? = null,
  @field:JsonProperty("showPositiveLineNumbers")
  @param:Optional
  val showPositiveLineNumbers: Boolean? = null,
  @field:JsonProperty("showNegativeLineNumbers")
  @param:Optional
  val showNegativeLineNumbers: Boolean? = null,
  @field:JsonProperty("showAreaNames")
  @param:Optional
  val showAreaNames: Boolean? = null,
  @field:JsonProperty("showLineNames")
  @param:Optional
  val showLineNames: Boolean? = null,
  @field:JsonProperty("showTrackSizes")
  @param:Optional
  val showTrackSizes: Boolean? = null,
  @field:JsonProperty("gridBorderColor")
  @param:Optional
  val gridBorderColor: RGBA? = null,
  @field:JsonProperty("cellBorderColor")
  @param:Optional
  @param:Deprecated
  val cellBorderColor: RGBA? = null,
  @field:JsonProperty("rowLineColor")
  @param:Optional
  val rowLineColor: RGBA? = null,
  @field:JsonProperty("columnLineColor")
  @param:Optional
  val columnLineColor: RGBA? = null,
  @field:JsonProperty("gridBorderDash")
  @param:Optional
  val gridBorderDash: Boolean? = null,
  @field:JsonProperty("cellBorderDash")
  @param:Optional
  @param:Deprecated
  val cellBorderDash: Boolean? = null,
  @field:JsonProperty("rowLineDash")
  @param:Optional
  val rowLineDash: Boolean? = null,
  @field:JsonProperty("columnLineDash")
  @param:Optional
  val columnLineDash: Boolean? = null,
  @field:JsonProperty("rowGapColor")
  @param:Optional
  val rowGapColor: RGBA? = null,
  @field:JsonProperty("rowHatchColor")
  @param:Optional
  val rowHatchColor: RGBA? = null,
  @field:JsonProperty("columnGapColor")
  @param:Optional
  val columnGapColor: RGBA? = null,
  @field:JsonProperty("columnHatchColor")
  @param:Optional
  val columnHatchColor: RGBA? = null,
  @field:JsonProperty("areaBorderColor")
  @param:Optional
  val areaBorderColor: RGBA? = null,
  @field:JsonProperty("gridBackgroundColor")
  @param:Optional
  val gridBackgroundColor: RGBA? = null,
)
