@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domsnapshot

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Snapshot(
  @property:SerialName("domNodes")
  val domNodes: List<DOMNode>,
  @property:SerialName("layoutTreeNodes")
  val layoutTreeNodes: List<LayoutTreeNode>,
  @property:SerialName("computedStyles")
  val computedStyles: List<ComputedStyle>,
)
