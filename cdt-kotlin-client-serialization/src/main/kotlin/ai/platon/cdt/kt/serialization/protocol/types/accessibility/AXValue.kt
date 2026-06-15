@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.accessibility
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Any
import kotlin.collections.List

/**
 * A single computed AX property.
 */
@Serializable
data class AXValue(
  @SerialName("type")
  val type: AXValueType,
  @SerialName("value")
  @param:Optional
  val `value`: Any? = null,
  @SerialName("relatedNodes")
  @param:Optional
  val relatedNodes: List<AXRelatedNode>? = null,
  @SerialName("sources")
  @param:Optional
  val sources: List<AXValueSource>? = null,
)
