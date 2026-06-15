@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.dom.Rect
import kotlin.Deprecated

@Serializable
data class LayoutMetrics(
  @SerialName("layoutViewport")
  @Deprecated("Deprecated by protocol")
  val layoutViewport: LayoutViewport,
  @SerialName("visualViewport")
  @Deprecated("Deprecated by protocol")
  val visualViewport: VisualViewport,
  @SerialName("contentSize")
  @Deprecated("Deprecated by protocol")
  val contentSize: Rect,
  @SerialName("cssLayoutViewport")
  val cssLayoutViewport: LayoutViewport,
  @SerialName("cssVisualViewport")
  val cssVisualViewport: VisualViewport,
  @SerialName("cssContentSize")
  val cssContentSize: Rect,
)
