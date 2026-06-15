@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int

@Serializable
data class ScrollSnapHighlightConfig(
  @SerialName("scrollSnapContainerHighlightConfig")
  val scrollSnapContainerHighlightConfig: ScrollSnapContainerHighlightConfig,
  @SerialName("nodeId")
  val nodeId: Int,
)
