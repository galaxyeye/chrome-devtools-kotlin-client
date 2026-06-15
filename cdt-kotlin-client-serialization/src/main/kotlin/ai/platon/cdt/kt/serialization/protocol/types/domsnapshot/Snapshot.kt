@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domsnapshot
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.collections.List

@Serializable
data class Snapshot(
  @SerialName("domNodes")
  val domNodes: List<DOMNode>,
  @SerialName("layoutTreeNodes")
  val layoutTreeNodes: List<LayoutTreeNode>,
  @SerialName("computedStyles")
  val computedStyles: List<ComputedStyle>,
)
