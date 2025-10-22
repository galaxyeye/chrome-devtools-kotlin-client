package ai.platon.cdt.kt.protocol.types.accessibility

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.collections.List

/**
 * A single computed AX property.
 */
data class AXValue(
  @field:JsonProperty("type")
  val type: AXValueType,
  @field:JsonProperty("value")
  @param:Optional
  val `value`: Any? = null,
  @field:JsonProperty("relatedNodes")
  @param:Optional
  val relatedNodes: List<AXRelatedNode>? = null,
  @field:JsonProperty("sources")
  @param:Optional
  val sources: List<AXValueSource>? = null,
)
