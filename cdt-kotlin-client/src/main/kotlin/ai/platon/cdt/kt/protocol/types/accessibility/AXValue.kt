package ai.platon.cdt.kt.protocol.types.accessibility

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.collections.List

/**
 * A single computed AX property.
 */
public data class AXValue(
  @field:JsonProperty("type")
  public val type: AXValueType,
  @field:JsonProperty("value")
  @param:Optional
  public val `value`: Any? = null,
  @field:JsonProperty("relatedNodes")
  @param:Optional
  public val relatedNodes: List<AXRelatedNode>? = null,
  @field:JsonProperty("sources")
  @param:Optional
  public val sources: List<AXValueSource>? = null,
)
