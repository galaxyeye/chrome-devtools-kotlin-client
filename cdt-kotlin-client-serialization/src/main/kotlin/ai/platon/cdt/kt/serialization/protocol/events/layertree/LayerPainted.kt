@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.layertree
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.dom.Rect
import kotlin.String

@Serializable
data class LayerPainted(
  @SerialName("layerId")
  val layerId: String,
  @SerialName("clip")
  val clip: Rect,
)
