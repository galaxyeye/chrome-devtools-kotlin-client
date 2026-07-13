@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IsolatedElementHighlightConfig(
  @property:SerialName("isolationModeHighlightConfig")
  val isolationModeHighlightConfig: IsolationModeHighlightConfig,
  @property:SerialName("nodeId")
  val nodeId: Int,
)
