@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.layertree

import ai.platon.cdt.kt.serialization.protocol.types.dom.Rect
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LayerPainted(
  @property:SerialName("layerId")
  val layerId: String,
  @property:SerialName("clip")
  val clip: Rect,
)
