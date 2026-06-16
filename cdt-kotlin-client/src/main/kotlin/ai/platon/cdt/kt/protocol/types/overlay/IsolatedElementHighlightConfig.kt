@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.overlay

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

data class IsolatedElementHighlightConfig(
  @param:JsonProperty("isolationModeHighlightConfig")
  val isolationModeHighlightConfig: IsolationModeHighlightConfig,
  @param:JsonProperty("nodeId")
  val nodeId: Int,
)
