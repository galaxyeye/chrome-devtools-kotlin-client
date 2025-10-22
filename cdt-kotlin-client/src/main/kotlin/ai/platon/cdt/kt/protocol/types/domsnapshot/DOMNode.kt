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
data class DOMNode(
  @field:JsonProperty("nodeType")
  val nodeType: Int,
  @field:JsonProperty("nodeName")
  val nodeName: String,
  @field:JsonProperty("nodeValue")
  val nodeValue: String,
  @field:JsonProperty("textValue")
  @param:Optional
  val textValue: String? = null,
  @field:JsonProperty("inputValue")
  @param:Optional
  val inputValue: String? = null,
  @field:JsonProperty("inputChecked")
  @param:Optional
  val inputChecked: Boolean? = null,
  @field:JsonProperty("optionSelected")
  @param:Optional
  val optionSelected: Boolean? = null,
  @field:JsonProperty("backendNodeId")
  val backendNodeId: Int,
  @field:JsonProperty("childNodeIndexes")
  @param:Optional
  val childNodeIndexes: List<Int>? = null,
  @field:JsonProperty("attributes")
  @param:Optional
  val attributes: List<NameValue>? = null,
  @field:JsonProperty("pseudoElementIndexes")
  @param:Optional
  val pseudoElementIndexes: List<Int>? = null,
  @field:JsonProperty("layoutNodeIndex")
  @param:Optional
  val layoutNodeIndex: Int? = null,
  @field:JsonProperty("documentURL")
  @param:Optional
  val documentURL: String? = null,
  @field:JsonProperty("baseURL")
  @param:Optional
  val baseURL: String? = null,
  @field:JsonProperty("contentLanguage")
  @param:Optional
  val contentLanguage: String? = null,
  @field:JsonProperty("documentEncoding")
  @param:Optional
  val documentEncoding: String? = null,
  @field:JsonProperty("publicId")
  @param:Optional
  val publicId: String? = null,
  @field:JsonProperty("systemId")
  @param:Optional
  val systemId: String? = null,
  @field:JsonProperty("frameId")
  @param:Optional
  val frameId: String? = null,
  @field:JsonProperty("contentDocumentIndex")
  @param:Optional
  val contentDocumentIndex: Int? = null,
  @field:JsonProperty("pseudoType")
  @param:Optional
  val pseudoType: PseudoType? = null,
  @field:JsonProperty("shadowRootType")
  @param:Optional
  val shadowRootType: ShadowRootType? = null,
  @field:JsonProperty("isClickable")
  @param:Optional
  val isClickable: Boolean? = null,
  @field:JsonProperty("eventListeners")
  @param:Optional
  val eventListeners: List<EventListener>? = null,
  @field:JsonProperty("currentSourceURL")
  @param:Optional
  val currentSourceURL: String? = null,
  @field:JsonProperty("originURL")
  @param:Optional
  val originURL: String? = null,
  @field:JsonProperty("scrollOffsetX")
  @param:Optional
  val scrollOffsetX: Double? = null,
  @field:JsonProperty("scrollOffsetY")
  @param:Optional
  val scrollOffsetY: Double? = null,
)
