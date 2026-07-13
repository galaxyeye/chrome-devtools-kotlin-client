@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domsnapshot

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Table containing nodes.
 */
@Serializable
data class NodeTreeSnapshot(
  @property:SerialName("parentIndex")
  @param:Optional
  val parentIndex: List<Int>? = null,
  @property:SerialName("nodeType")
  @param:Optional
  val nodeType: List<Int>? = null,
  @property:SerialName("shadowRootType")
  @param:Optional
  val shadowRootType: RareStringData? = null,
  @property:SerialName("nodeName")
  @param:Optional
  val nodeName: List<Int>? = null,
  @property:SerialName("nodeValue")
  @param:Optional
  val nodeValue: List<Int>? = null,
  @property:SerialName("backendNodeId")
  @param:Optional
  val backendNodeId: List<Int>? = null,
  @property:SerialName("attributes")
  @param:Optional
  val attributes: List<List<Int>>? = null,
  @property:SerialName("textValue")
  @param:Optional
  val textValue: RareStringData? = null,
  @property:SerialName("inputValue")
  @param:Optional
  val inputValue: RareStringData? = null,
  @property:SerialName("inputChecked")
  @param:Optional
  val inputChecked: RareBooleanData? = null,
  @property:SerialName("optionSelected")
  @param:Optional
  val optionSelected: RareBooleanData? = null,
  @property:SerialName("contentDocumentIndex")
  @param:Optional
  val contentDocumentIndex: RareIntegerData? = null,
  @property:SerialName("pseudoType")
  @param:Optional
  val pseudoType: RareStringData? = null,
  @property:SerialName("pseudoIdentifier")
  @param:Optional
  val pseudoIdentifier: RareStringData? = null,
  @property:SerialName("isClickable")
  @param:Optional
  val isClickable: RareBooleanData? = null,
  @property:SerialName("currentSourceURL")
  @param:Optional
  val currentSourceURL: RareStringData? = null,
  @property:SerialName("originURL")
  @param:Optional
  val originURL: RareStringData? = null,
)
