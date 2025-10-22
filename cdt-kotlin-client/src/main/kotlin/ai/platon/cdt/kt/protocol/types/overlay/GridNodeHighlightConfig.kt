package ai.platon.cdt.kt.protocol.types.overlay

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Configurations for Persistent Grid Highlight
 */
public data class GridNodeHighlightConfig(
  @field:JsonProperty("gridHighlightConfig")
  public val gridHighlightConfig: GridHighlightConfig,
  @field:JsonProperty("nodeId")
  public val nodeId: Int,
)
