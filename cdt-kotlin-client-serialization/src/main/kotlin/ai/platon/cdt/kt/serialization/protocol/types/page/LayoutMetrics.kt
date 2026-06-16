@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.types.dom.Rect
import kotlin.Deprecated
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LayoutMetrics(
  @property:SerialName("layoutViewport")
  @Deprecated("Deprecated by protocol")
  val layoutViewport: LayoutViewport,
  @property:SerialName("visualViewport")
  @Deprecated("Deprecated by protocol")
  val visualViewport: VisualViewport,
  @property:SerialName("contentSize")
  @Deprecated("Deprecated by protocol")
  val contentSize: Rect,
  @property:SerialName("cssLayoutViewport")
  val cssLayoutViewport: LayoutViewport,
  @property:SerialName("cssVisualViewport")
  val cssVisualViewport: VisualViewport,
  @property:SerialName("cssContentSize")
  val cssContentSize: Rect,
)
