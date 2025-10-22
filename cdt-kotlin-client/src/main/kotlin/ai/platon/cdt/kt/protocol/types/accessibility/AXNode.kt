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
data class AXNode(
  @field:JsonProperty("nodeId")
  val nodeId: String,
  @field:JsonProperty("ignored")
  val ignored: Boolean,
  @field:JsonProperty("ignoredReasons")
  @param:Optional
  val ignoredReasons: List<AXProperty>? = null,
  @field:JsonProperty("role")
  @param:Optional
  val role: AXValue? = null,
  @field:JsonProperty("name")
  @param:Optional
  val name: AXValue? = null,
  @field:JsonProperty("description")
  @param:Optional
  val description: AXValue? = null,
  @field:JsonProperty("value")
  @param:Optional
  val `value`: AXValue? = null,
  @field:JsonProperty("properties")
  @param:Optional
  val properties: List<AXProperty>? = null,
  @field:JsonProperty("childIds")
  @param:Optional
  val childIds: List<String>? = null,
  @field:JsonProperty("backendDOMNodeId")
  @param:Optional
  val backendDOMNodeId: Int? = null,
)
