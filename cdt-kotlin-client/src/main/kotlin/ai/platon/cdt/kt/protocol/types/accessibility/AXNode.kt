package ai.platon.cdt.kt.protocol.types.accessibility

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * A node in the accessibility tree.
 */
public data class AXNode(
  @field:JsonProperty("nodeId")
  public val nodeId: String,
  @field:JsonProperty("ignored")
  public val ignored: Boolean,
  @field:JsonProperty("ignoredReasons")
  @param:Optional
  public val ignoredReasons: List<AXProperty>? = null,
  @field:JsonProperty("role")
  @param:Optional
  public val role: AXValue? = null,
  @field:JsonProperty("name")
  @param:Optional
  public val name: AXValue? = null,
  @field:JsonProperty("description")
  @param:Optional
  public val description: AXValue? = null,
  @field:JsonProperty("value")
  @param:Optional
  public val `value`: AXValue? = null,
  @field:JsonProperty("properties")
  @param:Optional
  public val properties: List<AXProperty>? = null,
  @field:JsonProperty("childIds")
  @param:Optional
  public val childIds: List<String>? = null,
  @field:JsonProperty("backendDOMNodeId")
  @param:Optional
  public val backendDOMNodeId: Int? = null,
)
