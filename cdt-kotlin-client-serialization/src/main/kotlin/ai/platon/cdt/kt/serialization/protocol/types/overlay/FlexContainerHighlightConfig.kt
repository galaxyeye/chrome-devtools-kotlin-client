@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional

/**
 * Configuration data for the highlighting of Flex container elements.
 */
@Serializable
data class FlexContainerHighlightConfig(
  @SerialName("containerBorder")
  @param:Optional
  val containerBorder: LineStyle? = null,
  @SerialName("lineSeparator")
  @param:Optional
  val lineSeparator: LineStyle? = null,
  @SerialName("itemSeparator")
  @param:Optional
  val itemSeparator: LineStyle? = null,
  @SerialName("mainDistributedSpace")
  @param:Optional
  val mainDistributedSpace: BoxStyle? = null,
  @SerialName("crossDistributedSpace")
  @param:Optional
  val crossDistributedSpace: BoxStyle? = null,
  @SerialName("rowGapSpace")
  @param:Optional
  val rowGapSpace: BoxStyle? = null,
  @SerialName("columnGapSpace")
  @param:Optional
  val columnGapSpace: BoxStyle? = null,
  @SerialName("crossAlignment")
  @param:Optional
  val crossAlignment: LineStyle? = null,
)
