package ai.platon.cdt.kt.protocol.types.overlay

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.dom.RGBA
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

/**
 * Configuration data for the highlighting of page elements.
 */
public data class HighlightConfig(
    @JsonProperty("showInfo")
  @Optional
  public var showInfo: Boolean? = null,
    @JsonProperty("showStyles")
  @Optional
  public var showStyles: Boolean? = null,
    @JsonProperty("showRulers")
  @Optional
  public var showRulers: Boolean? = null,
    @JsonProperty("showAccessibilityInfo")
  @Optional
  public val showAccessibilityInfo: Boolean? = null,
    @JsonProperty("showExtensionLines")
  @Optional
  public var showExtensionLines: Boolean? = null,
    @JsonProperty("contentColor")
  @Optional
  public val contentColor: RGBA? = null,
    @JsonProperty("paddingColor")
  @Optional
  public val paddingColor: RGBA? = null,
    @JsonProperty("borderColor")
  @Optional
  public val borderColor: RGBA? = null,
    @JsonProperty("marginColor")
  @Optional
  public val marginColor: RGBA? = null,
    @JsonProperty("eventTargetColor")
  @Optional
  public val eventTargetColor: RGBA? = null,
    @JsonProperty("shapeColor")
  @Optional
  public var shapeColor: RGBA? = null,
    @JsonProperty("shapeMarginColor")
  @Optional
  public val shapeMarginColor: RGBA? = null,
    @JsonProperty("cssGridColor")
  @Optional
  public val cssGridColor: RGBA? = null,
    @JsonProperty("colorFormat")
  @Optional
  public val colorFormat: ColorFormat? = null,
    @JsonProperty("gridHighlightConfig")
  @Optional
  public val gridHighlightConfig: GridHighlightConfig? = null,
    @JsonProperty("flexContainerHighlightConfig")
  @Optional
  public val flexContainerHighlightConfig: FlexContainerHighlightConfig? = null,
    @JsonProperty("flexItemHighlightConfig")
  @Optional
  public val flexItemHighlightConfig: FlexItemHighlightConfig? = null,
    @JsonProperty("contrastAlgorithm")
  @Optional
  public val contrastAlgorithm: ContrastAlgorithm? = null,
)
