package ai.platon.cdt.kt.protocol.types.domsnapshot

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.collections.List

/**
 * Table containing nodes.
 */
data class NodeTreeSnapshot(
  @field:JsonProperty("parentIndex")
  @param:Optional
  val parentIndex: List<Int>? = null,
  @field:JsonProperty("nodeType")
  @param:Optional
  val nodeType: List<Int>? = null,
  @field:JsonProperty("nodeName")
  @param:Optional
  val nodeName: List<Int>? = null,
  @field:JsonProperty("nodeValue")
  @param:Optional
  val nodeValue: List<Int>? = null,
  @field:JsonProperty("backendNodeId")
  @param:Optional
  val backendNodeId: List<Int>? = null,
  @field:JsonProperty("attributes")
  @param:Optional
  val attributes: List<List<Int>>? = null,
  @field:JsonProperty("textValue")
  @param:Optional
  val textValue: RareStringData? = null,
  @field:JsonProperty("inputValue")
  @param:Optional
  val inputValue: RareStringData? = null,
  @field:JsonProperty("inputChecked")
  @param:Optional
  val inputChecked: RareBooleanData? = null,
  @field:JsonProperty("optionSelected")
  @param:Optional
  val optionSelected: RareBooleanData? = null,
  @field:JsonProperty("contentDocumentIndex")
  @param:Optional
  val contentDocumentIndex: RareIntegerData? = null,
  @field:JsonProperty("pseudoType")
  @param:Optional
  val pseudoType: RareStringData? = null,
  @field:JsonProperty("isClickable")
  @param:Optional
  val isClickable: RareBooleanData? = null,
  @field:JsonProperty("currentSourceURL")
  @param:Optional
  val currentSourceURL: RareStringData? = null,
  @field:JsonProperty("originURL")
  @param:Optional
  val originURL: RareStringData? = null,
)
