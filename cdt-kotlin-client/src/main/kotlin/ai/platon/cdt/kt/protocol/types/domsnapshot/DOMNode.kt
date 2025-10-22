package ai.platon.cdt.kt.protocol.types.domsnapshot

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.dom.PseudoType
import ai.platon.cdt.kt.protocol.types.dom.ShadowRootType
import ai.platon.cdt.kt.protocol.types.domdebugger.EventListener
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * A Node in the DOM tree.
 */
public data class DOMNode(
  @field:JsonProperty("nodeType")
  public val nodeType: Int,
  @field:JsonProperty("nodeName")
  public val nodeName: String,
  @field:JsonProperty("nodeValue")
  public val nodeValue: String,
  @field:JsonProperty("textValue")
  @param:Optional
  public val textValue: String? = null,
  @field:JsonProperty("inputValue")
  @param:Optional
  public val inputValue: String? = null,
  @field:JsonProperty("inputChecked")
  @param:Optional
  public val inputChecked: Boolean? = null,
  @field:JsonProperty("optionSelected")
  @param:Optional
  public val optionSelected: Boolean? = null,
  @field:JsonProperty("backendNodeId")
  public val backendNodeId: Int,
  @field:JsonProperty("childNodeIndexes")
  @param:Optional
  public val childNodeIndexes: List<Int>? = null,
  @field:JsonProperty("attributes")
  @param:Optional
  public val attributes: List<NameValue>? = null,
  @field:JsonProperty("pseudoElementIndexes")
  @param:Optional
  public val pseudoElementIndexes: List<Int>? = null,
  @field:JsonProperty("layoutNodeIndex")
  @param:Optional
  public val layoutNodeIndex: Int? = null,
  @field:JsonProperty("documentURL")
  @param:Optional
  public val documentURL: String? = null,
  @field:JsonProperty("baseURL")
  @param:Optional
  public val baseURL: String? = null,
  @field:JsonProperty("contentLanguage")
  @param:Optional
  public val contentLanguage: String? = null,
  @field:JsonProperty("documentEncoding")
  @param:Optional
  public val documentEncoding: String? = null,
  @field:JsonProperty("publicId")
  @param:Optional
  public val publicId: String? = null,
  @field:JsonProperty("systemId")
  @param:Optional
  public val systemId: String? = null,
  @field:JsonProperty("frameId")
  @param:Optional
  public val frameId: String? = null,
  @field:JsonProperty("contentDocumentIndex")
  @param:Optional
  public val contentDocumentIndex: Int? = null,
  @field:JsonProperty("pseudoType")
  @param:Optional
  public val pseudoType: PseudoType? = null,
  @field:JsonProperty("shadowRootType")
  @param:Optional
  public val shadowRootType: ShadowRootType? = null,
  @field:JsonProperty("isClickable")
  @param:Optional
  public val isClickable: Boolean? = null,
  @field:JsonProperty("eventListeners")
  @param:Optional
  public val eventListeners: List<EventListener>? = null,
  @field:JsonProperty("currentSourceURL")
  @param:Optional
  public val currentSourceURL: String? = null,
  @field:JsonProperty("originURL")
  @param:Optional
  public val originURL: String? = null,
  @field:JsonProperty("scrollOffsetX")
  @param:Optional
  public val scrollOffsetX: Double? = null,
  @field:JsonProperty("scrollOffsetY")
  @param:Optional
  public val scrollOffsetY: Double? = null,
)
