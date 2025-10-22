package ai.platon.cdt.kt.protocol.types.domsnapshot

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

data class Snapshot(
  @field:JsonProperty("domNodes")
  val domNodes: List<DOMNode>,
  @field:JsonProperty("layoutTreeNodes")
  val layoutTreeNodes: List<LayoutTreeNode>,
  @field:JsonProperty("computedStyles")
  val computedStyles: List<ComputedStyle>,
)
