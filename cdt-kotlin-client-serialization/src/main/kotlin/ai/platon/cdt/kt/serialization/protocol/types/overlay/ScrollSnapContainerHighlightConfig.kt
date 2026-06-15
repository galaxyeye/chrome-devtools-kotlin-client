@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.dom.RGBA

@Serializable
data class ScrollSnapContainerHighlightConfig(
  @SerialName("snapportBorder")
  @param:Optional
  val snapportBorder: LineStyle? = null,
  @SerialName("snapAreaBorder")
  @param:Optional
  val snapAreaBorder: LineStyle? = null,
  @SerialName("scrollMarginColor")
  @param:Optional
  val scrollMarginColor: RGBA? = null,
  @SerialName("scrollPaddingColor")
  @param:Optional
  val scrollPaddingColor: RGBA? = null,
)
