@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domsnapshot

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.dom.Rect
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Details of an element in the DOM tree with a LayoutObject.
 */
@Serializable
data class LayoutTreeNode(
  @property:SerialName("domNodeIndex")
  val domNodeIndex: Int,
  @property:SerialName("boundingBox")
  val boundingBox: Rect,
  @property:SerialName("layoutText")
  @param:Optional
  val layoutText: String? = null,
  @property:SerialName("inlineTextNodes")
  @param:Optional
  val inlineTextNodes: List<InlineTextBox>? = null,
  @property:SerialName("styleIndex")
  @param:Optional
  val styleIndex: Int? = null,
  @property:SerialName("paintOrder")
  @param:Optional
  val paintOrder: Int? = null,
  @property:SerialName("isStackingContext")
  @param:Optional
  val isStackingContext: Boolean? = null,
)
