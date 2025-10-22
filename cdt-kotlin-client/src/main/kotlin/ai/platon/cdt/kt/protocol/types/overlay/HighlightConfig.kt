package ai.platon.cdt.kt.protocol.types.overlay

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.dom.RGBA
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

/**
 * Configuration data for the highlighting of page elements.
 */
public data class HighlightConfig(
  @field:JsonProperty("showInfo")
  @param:Optional
  public val showInfo: Boolean? = null,
  @field:JsonProperty("showStyles")
  @param:Optional
  public val showStyles: Boolean? = null,
  @field:JsonProperty("showRulers")
  @param:Optional
  public val showRulers: Boolean? = null,
  @field:JsonProperty("showAccessibilityInfo")
  @param:Optional
  public val showAccessibilityInfo: Boolean? = null,
  @field:JsonProperty("showExtensionLines")
  @param:Optional
  public val showExtensionLines: Boolean? = null,
  @field:JsonProperty("contentColor")
  @param:Optional
  public val contentColor: RGBA? = null,
  @field:JsonProperty("paddingColor")
  @param:Optional
  public val paddingColor: RGBA? = null,
  @field:JsonProperty("borderColor")
  @param:Optional
  public val borderColor: RGBA? = null,
  @field:JsonProperty("marginColor")
  @param:Optional
  public val marginColor: RGBA? = null,
  @field:JsonProperty("eventTargetColor")
  @param:Optional
  public val eventTargetColor: RGBA? = null,
  @field:JsonProperty("shapeColor")
  @param:Optional
  public val shapeColor: RGBA? = null,
  @field:JsonProperty("shapeMarginColor")
  @param:Optional
  public val shapeMarginColor: RGBA? = null,
  @field:JsonProperty("cssGridColor")
  @param:Optional
  public val cssGridColor: RGBA? = null,
  @field:JsonProperty("colorFormat")
  @param:Optional
  public val colorFormat: ColorFormat? = null,
  @field:JsonProperty("gridHighlightConfig")
  @param:Optional
  public val gridHighlightConfig: GridHighlightConfig? = null,
  @field:JsonProperty("flexContainerHighlightConfig")
  @param:Optional
  public val flexContainerHighlightConfig: FlexContainerHighlightConfig? = null,
  @field:JsonProperty("flexItemHighlightConfig")
  @param:Optional
  public val flexItemHighlightConfig: FlexItemHighlightConfig? = null,
  @field:JsonProperty("contrastAlgorithm")
  @param:Optional
  public val contrastAlgorithm: ContrastAlgorithm? = null,
)
