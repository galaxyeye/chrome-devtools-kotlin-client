@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domsnapshot
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.collections.List

/**
 * Table containing nodes.
 */
@Serializable
data class NodeTreeSnapshot(
  @SerialName("parentIndex")
  @param:Optional
  val parentIndex: List<Int>? = null,
  @SerialName("nodeType")
  @param:Optional
  val nodeType: List<Int>? = null,
  @SerialName("nodeName")
  @param:Optional
  val nodeName: List<Int>? = null,
  @SerialName("nodeValue")
  @param:Optional
  val nodeValue: List<Int>? = null,
  @SerialName("backendNodeId")
  @param:Optional
  val backendNodeId: List<Int>? = null,
  @SerialName("attributes")
  @param:Optional
  val attributes: List<List<Int>>? = null,
  @SerialName("textValue")
  @param:Optional
  val textValue: RareStringData? = null,
  @SerialName("inputValue")
  @param:Optional
  val inputValue: RareStringData? = null,
  @SerialName("inputChecked")
  @param:Optional
  val inputChecked: RareBooleanData? = null,
  @SerialName("optionSelected")
  @param:Optional
  val optionSelected: RareBooleanData? = null,
  @SerialName("contentDocumentIndex")
  @param:Optional
  val contentDocumentIndex: RareIntegerData? = null,
  @SerialName("pseudoType")
  @param:Optional
  val pseudoType: RareStringData? = null,
  @SerialName("isClickable")
  @param:Optional
  val isClickable: RareBooleanData? = null,
  @SerialName("currentSourceURL")
  @param:Optional
  val currentSourceURL: RareStringData? = null,
  @SerialName("originURL")
  @param:Optional
  val originURL: RareStringData? = null,
)
