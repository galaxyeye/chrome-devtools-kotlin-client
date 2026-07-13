@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Configuration data for the highlighting of Flex container elements.
 */
@Serializable
data class FlexContainerHighlightConfig(
  @property:SerialName("containerBorder")
  @param:Optional
  val containerBorder: LineStyle? = null,
  @property:SerialName("lineSeparator")
  @param:Optional
  val lineSeparator: LineStyle? = null,
  @property:SerialName("itemSeparator")
  @param:Optional
  val itemSeparator: LineStyle? = null,
  @property:SerialName("mainDistributedSpace")
  @param:Optional
  val mainDistributedSpace: BoxStyle? = null,
  @property:SerialName("crossDistributedSpace")
  @param:Optional
  val crossDistributedSpace: BoxStyle? = null,
  @property:SerialName("rowGapSpace")
  @param:Optional
  val rowGapSpace: BoxStyle? = null,
  @property:SerialName("columnGapSpace")
  @param:Optional
  val columnGapSpace: BoxStyle? = null,
  @property:SerialName("crossAlignment")
  @param:Optional
  val crossAlignment: LineStyle? = null,
)
