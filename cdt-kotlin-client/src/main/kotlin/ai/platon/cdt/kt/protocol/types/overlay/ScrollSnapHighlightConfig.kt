package ai.platon.cdt.kt.protocol.types.overlay

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

data class ScrollSnapHighlightConfig(
  @field:JsonProperty("scrollSnapContainerHighlightConfig")
  val scrollSnapContainerHighlightConfig: ScrollSnapContainerHighlightConfig,
  @field:JsonProperty("nodeId")
  val nodeId: Int,
)
