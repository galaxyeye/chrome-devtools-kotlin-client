@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.accessibility

import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

/**
 * A single computed AX property.
 */
@Serializable
data class AXValue(
  @property:SerialName("type")
  val type: AXValueType,
  @property:SerialName("value")
  @param:Optional
  val `value`: JsonElement? = null,
  @property:SerialName("relatedNodes")
  @param:Optional
  val relatedNodes: List<AXRelatedNode>? = null,
  @property:SerialName("sources")
  @param:Optional
  val sources: List<AXValueSource>? = null,
)
