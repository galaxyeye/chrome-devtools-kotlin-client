package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.types.dom.Rect
import com.fasterxml.jackson.`annotation`.JsonProperty
import java.lang.Deprecated

public data class LayoutMetrics(
  @field:JsonProperty("layoutViewport")
  @param:Deprecated
  public val layoutViewport: LayoutViewport,
  @field:JsonProperty("visualViewport")
  @param:Deprecated
  public val visualViewport: VisualViewport,
  @field:JsonProperty("contentSize")
  @param:Deprecated
  public val contentSize: Rect,
  @field:JsonProperty("cssLayoutViewport")
  public val cssLayoutViewport: LayoutViewport,
  @field:JsonProperty("cssVisualViewport")
  public val cssVisualViewport: VisualViewport,
  @field:JsonProperty("cssContentSize")
  public val cssContentSize: Rect,
)
