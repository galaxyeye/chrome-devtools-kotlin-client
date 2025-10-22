package ai.platon.cdt.kt.protocol.types.overlay

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

data class FlexNodeHighlightConfig(
  @field:JsonProperty("flexContainerHighlightConfig")
  val flexContainerHighlightConfig: FlexContainerHighlightConfig,
  @field:JsonProperty("nodeId")
  val nodeId: Int,
)
