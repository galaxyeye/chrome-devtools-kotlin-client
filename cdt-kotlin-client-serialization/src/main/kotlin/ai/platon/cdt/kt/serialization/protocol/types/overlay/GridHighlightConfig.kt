@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.dom.RGBA
import kotlin.Boolean
import kotlin.Deprecated
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Configuration data for the highlighting of Grid elements.
 */
@Serializable
data class GridHighlightConfig(
  @property:SerialName("showGridExtensionLines")
  @param:Optional
  val showGridExtensionLines: Boolean? = null,
  @property:SerialName("showPositiveLineNumbers")
  @param:Optional
  val showPositiveLineNumbers: Boolean? = null,
  @property:SerialName("showNegativeLineNumbers")
  @param:Optional
  val showNegativeLineNumbers: Boolean? = null,
  @property:SerialName("showAreaNames")
  @param:Optional
  val showAreaNames: Boolean? = null,
  @property:SerialName("showLineNames")
  @param:Optional
  val showLineNames: Boolean? = null,
  @property:SerialName("showTrackSizes")
  @param:Optional
  val showTrackSizes: Boolean? = null,
  @property:SerialName("gridBorderColor")
  @param:Optional
  val gridBorderColor: RGBA? = null,
  @property:SerialName("cellBorderColor")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val cellBorderColor: RGBA? = null,
  @property:SerialName("rowLineColor")
  @param:Optional
  val rowLineColor: RGBA? = null,
  @property:SerialName("columnLineColor")
  @param:Optional
  val columnLineColor: RGBA? = null,
  @property:SerialName("gridBorderDash")
  @param:Optional
  val gridBorderDash: Boolean? = null,
  @property:SerialName("cellBorderDash")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val cellBorderDash: Boolean? = null,
  @property:SerialName("rowLineDash")
  @param:Optional
  val rowLineDash: Boolean? = null,
  @property:SerialName("columnLineDash")
  @param:Optional
  val columnLineDash: Boolean? = null,
  @property:SerialName("rowGapColor")
  @param:Optional
  val rowGapColor: RGBA? = null,
  @property:SerialName("rowHatchColor")
  @param:Optional
  val rowHatchColor: RGBA? = null,
  @property:SerialName("columnGapColor")
  @param:Optional
  val columnGapColor: RGBA? = null,
  @property:SerialName("columnHatchColor")
  @param:Optional
  val columnHatchColor: RGBA? = null,
  @property:SerialName("areaBorderColor")
  @param:Optional
  val areaBorderColor: RGBA? = null,
  @property:SerialName("gridBackgroundColor")
  @param:Optional
  val gridBackgroundColor: RGBA? = null,
)
