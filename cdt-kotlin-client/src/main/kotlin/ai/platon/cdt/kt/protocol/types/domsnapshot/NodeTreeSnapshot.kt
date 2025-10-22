package ai.platon.cdt.kt.protocol.types.domsnapshot

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.collections.List

/**
 * Table containing nodes.
 */
public data class NodeTreeSnapshot(
  @field:JsonProperty("parentIndex")
  @param:Optional
  public val parentIndex: List<Int>? = null,
  @field:JsonProperty("nodeType")
  @param:Optional
  public val nodeType: List<Int>? = null,
  @field:JsonProperty("nodeName")
  @param:Optional
  public val nodeName: List<Int>? = null,
  @field:JsonProperty("nodeValue")
  @param:Optional
  public val nodeValue: List<Int>? = null,
  @field:JsonProperty("backendNodeId")
  @param:Optional
  public val backendNodeId: List<Int>? = null,
  @field:JsonProperty("attributes")
  @param:Optional
  public val attributes: List<List<Int>>? = null,
  @field:JsonProperty("textValue")
  @param:Optional
  public val textValue: RareStringData? = null,
  @field:JsonProperty("inputValue")
  @param:Optional
  public val inputValue: RareStringData? = null,
  @field:JsonProperty("inputChecked")
  @param:Optional
  public val inputChecked: RareBooleanData? = null,
  @field:JsonProperty("optionSelected")
  @param:Optional
  public val optionSelected: RareBooleanData? = null,
  @field:JsonProperty("contentDocumentIndex")
  @param:Optional
  public val contentDocumentIndex: RareIntegerData? = null,
  @field:JsonProperty("pseudoType")
  @param:Optional
  public val pseudoType: RareStringData? = null,
  @field:JsonProperty("isClickable")
  @param:Optional
  public val isClickable: RareBooleanData? = null,
  @field:JsonProperty("currentSourceURL")
  @param:Optional
  public val currentSourceURL: RareStringData? = null,
  @field:JsonProperty("originURL")
  @param:Optional
  public val originURL: RareStringData? = null,
)
