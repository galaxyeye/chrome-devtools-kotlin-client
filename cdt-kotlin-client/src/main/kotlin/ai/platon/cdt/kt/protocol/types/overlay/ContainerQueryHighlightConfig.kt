@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.overlay

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

data class ContainerQueryHighlightConfig(
  @param:JsonProperty("containerQueryContainerHighlightConfig")
  val containerQueryContainerHighlightConfig: ContainerQueryContainerHighlightConfig,
  @param:JsonProperty("nodeId")
  val nodeId: Int,
)
