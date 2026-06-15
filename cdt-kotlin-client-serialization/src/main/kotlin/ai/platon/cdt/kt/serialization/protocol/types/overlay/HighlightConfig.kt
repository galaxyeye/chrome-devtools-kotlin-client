@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.dom.RGBA
import kotlin.Boolean

/**
 * Configuration data for the highlighting of page elements.
 */
@Serializable
data class HighlightConfig(
  @SerialName("showInfo")
  @param:Optional
  val showInfo: Boolean? = null,
  @SerialName("showStyles")
  @param:Optional
  val showStyles: Boolean? = null,
  @SerialName("showRulers")
  @param:Optional
  val showRulers: Boolean? = null,
  @SerialName("showAccessibilityInfo")
  @param:Optional
  val showAccessibilityInfo: Boolean? = null,
  @SerialName("showExtensionLines")
  @param:Optional
  val showExtensionLines: Boolean? = null,
  @SerialName("contentColor")
  @param:Optional
  val contentColor: RGBA? = null,
  @SerialName("paddingColor")
  @param:Optional
  val paddingColor: RGBA? = null,
  @SerialName("borderColor")
  @param:Optional
  val borderColor: RGBA? = null,
  @SerialName("marginColor")
  @param:Optional
  val marginColor: RGBA? = null,
  @SerialName("eventTargetColor")
  @param:Optional
  val eventTargetColor: RGBA? = null,
  @SerialName("shapeColor")
  @param:Optional
  val shapeColor: RGBA? = null,
  @SerialName("shapeMarginColor")
  @param:Optional
  val shapeMarginColor: RGBA? = null,
  @SerialName("cssGridColor")
  @param:Optional
  val cssGridColor: RGBA? = null,
  @SerialName("colorFormat")
  @param:Optional
  val colorFormat: ColorFormat? = null,
  @SerialName("gridHighlightConfig")
  @param:Optional
  val gridHighlightConfig: GridHighlightConfig? = null,
  @SerialName("flexContainerHighlightConfig")
  @param:Optional
  val flexContainerHighlightConfig: FlexContainerHighlightConfig? = null,
  @SerialName("flexItemHighlightConfig")
  @param:Optional
  val flexItemHighlightConfig: FlexItemHighlightConfig? = null,
  @SerialName("contrastAlgorithm")
  @param:Optional
  val contrastAlgorithm: ContrastAlgorithm? = null,
)
