@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.accessibility

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A node in the accessibility tree.
 */
@Serializable
data class AXNode(
  @property:SerialName("nodeId")
  val nodeId: String,
  @property:SerialName("ignored")
  val ignored: Boolean,
  @property:SerialName("ignoredReasons")
  @param:Optional
  val ignoredReasons: List<AXProperty>? = null,
  @property:SerialName("role")
  @param:Optional
  val role: AXValue? = null,
  @property:SerialName("chromeRole")
  @param:Optional
  val chromeRole: AXValue? = null,
  @property:SerialName("name")
  @param:Optional
  val name: AXValue? = null,
  @property:SerialName("description")
  @param:Optional
  val description: AXValue? = null,
  @property:SerialName("value")
  @param:Optional
  val `value`: AXValue? = null,
  @property:SerialName("properties")
  @param:Optional
  val properties: List<AXProperty>? = null,
  @property:SerialName("parentId")
  @param:Optional
  val parentId: String? = null,
  @property:SerialName("childIds")
  @param:Optional
  val childIds: List<String>? = null,
  @property:SerialName("backendDOMNodeId")
  @param:Optional
  val backendDOMNodeId: Int? = null,
  @property:SerialName("frameId")
  @param:Optional
  val frameId: String? = null,
)
