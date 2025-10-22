package ai.platon.cdt.kt.protocol.types.performancetimeline

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.dom.Rect
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

public data class LayoutShiftAttribution(
  @field:JsonProperty("previousRect")
  public val previousRect: Rect,
  @field:JsonProperty("currentRect")
  public val currentRect: Rect,
  @field:JsonProperty("nodeId")
  @param:Optional
  public val nodeId: Int? = null,
)
