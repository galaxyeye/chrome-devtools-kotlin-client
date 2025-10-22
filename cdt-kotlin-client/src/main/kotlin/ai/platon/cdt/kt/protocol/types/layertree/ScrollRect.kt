package ai.platon.cdt.kt.protocol.types.layertree

import ai.platon.cdt.kt.protocol.types.dom.Rect
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Rectangle where scrolling happens on the main thread.
 */
data class ScrollRect(
  @field:JsonProperty("rect")
  val rect: Rect,
  @field:JsonProperty("type")
  val type: ScrollRectType,
)
