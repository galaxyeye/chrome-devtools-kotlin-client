@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ScrollSnapHighlightConfig(
  @property:SerialName("scrollSnapContainerHighlightConfig")
  val scrollSnapContainerHighlightConfig: ScrollSnapContainerHighlightConfig,
  @property:SerialName("nodeId")
  val nodeId: Int,
)
