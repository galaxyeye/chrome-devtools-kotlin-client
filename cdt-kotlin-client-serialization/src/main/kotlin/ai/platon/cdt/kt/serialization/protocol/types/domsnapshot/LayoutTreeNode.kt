@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domsnapshot
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.dom.Rect
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Details of an element in the DOM tree with a LayoutObject.
 */
@Serializable
data class LayoutTreeNode(
  @SerialName("domNodeIndex")
  val domNodeIndex: Int,
  @SerialName("boundingBox")
  val boundingBox: Rect,
  @SerialName("layoutText")
  @param:Optional
  val layoutText: String? = null,
  @SerialName("inlineTextNodes")
  @param:Optional
  val inlineTextNodes: List<InlineTextBox>? = null,
  @SerialName("styleIndex")
  @param:Optional
  val styleIndex: Int? = null,
  @SerialName("paintOrder")
  @param:Optional
  val paintOrder: Int? = null,
  @SerialName("isStackingContext")
  @param:Optional
  val isStackingContext: Boolean? = null,
)
