@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.dom.RGBA
import kotlin.Boolean
import kotlin.Deprecated

/**
 * Configuration data for the highlighting of Grid elements.
 */
@Serializable
data class GridHighlightConfig(
  @SerialName("showGridExtensionLines")
  @param:Optional
  val showGridExtensionLines: Boolean? = null,
  @SerialName("showPositiveLineNumbers")
  @param:Optional
  val showPositiveLineNumbers: Boolean? = null,
  @SerialName("showNegativeLineNumbers")
  @param:Optional
  val showNegativeLineNumbers: Boolean? = null,
  @SerialName("showAreaNames")
  @param:Optional
  val showAreaNames: Boolean? = null,
  @SerialName("showLineNames")
  @param:Optional
  val showLineNames: Boolean? = null,
  @SerialName("showTrackSizes")
  @param:Optional
  val showTrackSizes: Boolean? = null,
  @SerialName("gridBorderColor")
  @param:Optional
  val gridBorderColor: RGBA? = null,
  @SerialName("cellBorderColor")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val cellBorderColor: RGBA? = null,
  @SerialName("rowLineColor")
  @param:Optional
  val rowLineColor: RGBA? = null,
  @SerialName("columnLineColor")
  @param:Optional
  val columnLineColor: RGBA? = null,
  @SerialName("gridBorderDash")
  @param:Optional
  val gridBorderDash: Boolean? = null,
  @SerialName("cellBorderDash")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val cellBorderDash: Boolean? = null,
  @SerialName("rowLineDash")
  @param:Optional
  val rowLineDash: Boolean? = null,
  @SerialName("columnLineDash")
  @param:Optional
  val columnLineDash: Boolean? = null,
  @SerialName("rowGapColor")
  @param:Optional
  val rowGapColor: RGBA? = null,
  @SerialName("rowHatchColor")
  @param:Optional
  val rowHatchColor: RGBA? = null,
  @SerialName("columnGapColor")
  @param:Optional
  val columnGapColor: RGBA? = null,
  @SerialName("columnHatchColor")
  @param:Optional
  val columnHatchColor: RGBA? = null,
  @SerialName("areaBorderColor")
  @param:Optional
  val areaBorderColor: RGBA? = null,
  @SerialName("gridBackgroundColor")
  @param:Optional
  val gridBackgroundColor: RGBA? = null,
)
