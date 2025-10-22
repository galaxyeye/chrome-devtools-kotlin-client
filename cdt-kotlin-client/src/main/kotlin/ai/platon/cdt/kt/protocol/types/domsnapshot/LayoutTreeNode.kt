package ai.platon.cdt.kt.protocol.types.domsnapshot

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.dom.Rect
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Details of an element in the DOM tree with a LayoutObject.
 */
data class LayoutTreeNode(
  @field:JsonProperty("domNodeIndex")
  val domNodeIndex: Int,
  @field:JsonProperty("boundingBox")
  val boundingBox: Rect,
  @field:JsonProperty("layoutText")
  @param:Optional
  val layoutText: String? = null,
  @field:JsonProperty("inlineTextNodes")
  @param:Optional
  val inlineTextNodes: List<InlineTextBox>? = null,
  @field:JsonProperty("styleIndex")
  @param:Optional
  val styleIndex: Int? = null,
  @field:JsonProperty("paintOrder")
  @param:Optional
  val paintOrder: Int? = null,
  @field:JsonProperty("isStackingContext")
  @param:Optional
  val isStackingContext: Boolean? = null,
)
