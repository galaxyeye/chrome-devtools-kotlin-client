package ai.platon.cdt.kt.protocol.types.performancetimeline

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.dom.Rect
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

data class LayoutShiftAttribution(
  @field:JsonProperty("previousRect")
  val previousRect: Rect,
  @field:JsonProperty("currentRect")
  val currentRect: Rect,
  @field:JsonProperty("nodeId")
  @param:Optional
  val nodeId: Int? = null,
)
