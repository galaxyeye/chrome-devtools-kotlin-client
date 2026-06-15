@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.layertree
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.layertree.Layer
import kotlin.collections.List

@Serializable
data class LayerTreeDidChange(
  @SerialName("layers")
  @param:Optional
  val layers: List<Layer>? = null,
)
