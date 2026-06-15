@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.accessibility
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
/**
 * A node in the accessibility tree.
 */
@Serializable
data class AXNode(
  @SerialName("nodeId")
  val nodeId: String,
  @SerialName("ignored")
  val ignored: Boolean,
  @SerialName("ignoredReasons")
  @param:Optional
  val ignoredReasons: List<AXProperty>? = null,
  @SerialName("role")
  @param:Optional
  val role: AXValue? = null,
  @SerialName("name")
  @param:Optional
  val name: AXValue? = null,
  @SerialName("description")
  @param:Optional
  val description: AXValue? = null,
  @SerialName("value")
  @param:Optional
  val `value`: AXValue? = null,
  @SerialName("properties")
  @param:Optional
  val properties: List<AXProperty>? = null,
  @SerialName("childIds")
  @param:Optional
  val childIds: List<String>? = null,
  @SerialName("backendDOMNodeId")
  @param:Optional
  val backendDOMNodeId: Int? = null,
)
