@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int

@Serializable
data class FlexNodeHighlightConfig(
  @SerialName("flexContainerHighlightConfig")
  val flexContainerHighlightConfig: FlexContainerHighlightConfig,
  @SerialName("nodeId")
  val nodeId: Int,
)
