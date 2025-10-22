package ai.platon.cdt.kt.protocol.types.overlay

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.dom.RGBA
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

/**
 * Configuration data for the highlighting of page elements.
 */
data class HighlightConfig(
  @field:JsonProperty("showInfo")
  @param:Optional
  val showInfo: Boolean? = null,
  @field:JsonProperty("showStyles")
  @param:Optional
  val showStyles: Boolean? = null,
  @field:JsonProperty("showRulers")
  @param:Optional
  val showRulers: Boolean? = null,
  @field:JsonProperty("showAccessibilityInfo")
  @param:Optional
  val showAccessibilityInfo: Boolean? = null,
  @field:JsonProperty("showExtensionLines")
  @param:Optional
  val showExtensionLines: Boolean? = null,
  @field:JsonProperty("contentColor")
  @param:Optional
  val contentColor: RGBA? = null,
  @field:JsonProperty("paddingColor")
  @param:Optional
  val paddingColor: RGBA? = null,
  @field:JsonProperty("borderColor")
  @param:Optional
  val borderColor: RGBA? = null,
  @field:JsonProperty("marginColor")
  @param:Optional
  val marginColor: RGBA? = null,
  @field:JsonProperty("eventTargetColor")
  @param:Optional
  val eventTargetColor: RGBA? = null,
  @field:JsonProperty("shapeColor")
  @param:Optional
  val shapeColor: RGBA? = null,
  @field:JsonProperty("shapeMarginColor")
  @param:Optional
  val shapeMarginColor: RGBA? = null,
  @field:JsonProperty("cssGridColor")
  @param:Optional
  val cssGridColor: RGBA? = null,
  @field:JsonProperty("colorFormat")
  @param:Optional
  val colorFormat: ColorFormat? = null,
  @field:JsonProperty("gridHighlightConfig")
  @param:Optional
  val gridHighlightConfig: GridHighlightConfig? = null,
  @field:JsonProperty("flexContainerHighlightConfig")
  @param:Optional
  val flexContainerHighlightConfig: FlexContainerHighlightConfig? = null,
  @field:JsonProperty("flexItemHighlightConfig")
  @param:Optional
  val flexItemHighlightConfig: FlexItemHighlightConfig? = null,
  @field:JsonProperty("contrastAlgorithm")
  @param:Optional
  val contrastAlgorithm: ContrastAlgorithm? = null,
)
