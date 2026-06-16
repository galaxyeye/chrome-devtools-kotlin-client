@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.dom.RGBA
import kotlin.Boolean
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Configuration data for the highlighting of page elements.
 */
@Serializable
data class HighlightConfig(
  @property:SerialName("showInfo")
  @param:Optional
  val showInfo: Boolean? = null,
  @property:SerialName("showStyles")
  @param:Optional
  val showStyles: Boolean? = null,
  @property:SerialName("showRulers")
  @param:Optional
  val showRulers: Boolean? = null,
  @property:SerialName("showAccessibilityInfo")
  @param:Optional
  val showAccessibilityInfo: Boolean? = null,
  @property:SerialName("showExtensionLines")
  @param:Optional
  val showExtensionLines: Boolean? = null,
  @property:SerialName("contentColor")
  @param:Optional
  val contentColor: RGBA? = null,
  @property:SerialName("paddingColor")
  @param:Optional
  val paddingColor: RGBA? = null,
  @property:SerialName("borderColor")
  @param:Optional
  val borderColor: RGBA? = null,
  @property:SerialName("marginColor")
  @param:Optional
  val marginColor: RGBA? = null,
  @property:SerialName("eventTargetColor")
  @param:Optional
  val eventTargetColor: RGBA? = null,
  @property:SerialName("shapeColor")
  @param:Optional
  val shapeColor: RGBA? = null,
  @property:SerialName("shapeMarginColor")
  @param:Optional
  val shapeMarginColor: RGBA? = null,
  @property:SerialName("cssGridColor")
  @param:Optional
  val cssGridColor: RGBA? = null,
  @property:SerialName("colorFormat")
  @param:Optional
  val colorFormat: ColorFormat? = null,
  @property:SerialName("gridHighlightConfig")
  @param:Optional
  val gridHighlightConfig: GridHighlightConfig? = null,
  @property:SerialName("flexContainerHighlightConfig")
  @param:Optional
  val flexContainerHighlightConfig: FlexContainerHighlightConfig? = null,
  @property:SerialName("flexItemHighlightConfig")
  @param:Optional
  val flexItemHighlightConfig: FlexItemHighlightConfig? = null,
  @property:SerialName("contrastAlgorithm")
  @param:Optional
  val contrastAlgorithm: ContrastAlgorithm? = null,
  @property:SerialName("containerQueryContainerHighlightConfig")
  @param:Optional
  val containerQueryContainerHighlightConfig: ContainerQueryContainerHighlightConfig? = null,
)
