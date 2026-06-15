@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int

/**
 * Configurations for Persistent Grid Highlight
 */
@Serializable
data class GridNodeHighlightConfig(
  @SerialName("gridHighlightConfig")
  val gridHighlightConfig: GridHighlightConfig,
  @SerialName("nodeId")
  val nodeId: Int,
)
