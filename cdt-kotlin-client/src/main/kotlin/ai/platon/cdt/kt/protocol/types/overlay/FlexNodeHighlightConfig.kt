package ai.platon.cdt.kt.protocol.types.overlay

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

public data class FlexNodeHighlightConfig(
  @field:JsonProperty("flexContainerHighlightConfig")
  public val flexContainerHighlightConfig: FlexContainerHighlightConfig,
  @field:JsonProperty("nodeId")
  public val nodeId: Int,
)
