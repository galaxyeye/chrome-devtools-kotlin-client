package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.types.dom.Rect
import com.fasterxml.jackson.`annotation`.JsonProperty
import java.lang.Deprecated

data class LayoutMetrics(
  @field:JsonProperty("layoutViewport")
  @param:Deprecated
  val layoutViewport: LayoutViewport,
  @field:JsonProperty("visualViewport")
  @param:Deprecated
  val visualViewport: VisualViewport,
  @field:JsonProperty("contentSize")
  @param:Deprecated
  val contentSize: Rect,
  @field:JsonProperty("cssLayoutViewport")
  val cssLayoutViewport: LayoutViewport,
  @field:JsonProperty("cssVisualViewport")
  val cssVisualViewport: VisualViewport,
  @field:JsonProperty("cssContentSize")
  val cssContentSize: Rect,
)
