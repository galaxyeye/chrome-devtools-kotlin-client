@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Configurations for Persistent Grid Highlight
 */
@Serializable
data class GridNodeHighlightConfig(
  @property:SerialName("gridHighlightConfig")
  val gridHighlightConfig: GridHighlightConfig,
  @property:SerialName("nodeId")
  val nodeId: Int,
)
