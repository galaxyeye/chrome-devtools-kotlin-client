@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.dom.RGBA
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ScrollSnapContainerHighlightConfig(
  @property:SerialName("snapportBorder")
  @param:Optional
  val snapportBorder: LineStyle? = null,
  @property:SerialName("snapAreaBorder")
  @param:Optional
  val snapAreaBorder: LineStyle? = null,
  @property:SerialName("scrollMarginColor")
  @param:Optional
  val scrollMarginColor: RGBA? = null,
  @property:SerialName("scrollPaddingColor")
  @param:Optional
  val scrollPaddingColor: RGBA? = null,
)
