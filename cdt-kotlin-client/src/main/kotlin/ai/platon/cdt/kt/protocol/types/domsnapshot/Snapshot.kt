package ai.platon.cdt.kt.protocol.types.domsnapshot

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

public data class Snapshot(
  @field:JsonProperty("domNodes")
  public val domNodes: List<DOMNode>,
  @field:JsonProperty("layoutTreeNodes")
  public val layoutTreeNodes: List<LayoutTreeNode>,
  @field:JsonProperty("computedStyles")
  public val computedStyles: List<ComputedStyle>,
)
