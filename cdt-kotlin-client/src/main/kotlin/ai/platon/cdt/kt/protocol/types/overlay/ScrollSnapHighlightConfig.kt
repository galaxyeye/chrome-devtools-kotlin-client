package ai.platon.cdt.kt.protocol.types.overlay

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

public data class ScrollSnapHighlightConfig(
  @field:JsonProperty("scrollSnapContainerHighlightConfig")
  public val scrollSnapContainerHighlightConfig: ScrollSnapContainerHighlightConfig,
  @field:JsonProperty("nodeId")
  public val nodeId: Int,
)
