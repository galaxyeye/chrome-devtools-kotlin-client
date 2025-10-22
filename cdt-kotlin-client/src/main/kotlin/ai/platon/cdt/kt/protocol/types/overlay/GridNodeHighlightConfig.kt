package ai.platon.cdt.kt.protocol.types.overlay

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Configurations for Persistent Grid Highlight
 */
data class GridNodeHighlightConfig(
  @field:JsonProperty("gridHighlightConfig")
  val gridHighlightConfig: GridHighlightConfig,
  @field:JsonProperty("nodeId")
  val nodeId: Int,
)
