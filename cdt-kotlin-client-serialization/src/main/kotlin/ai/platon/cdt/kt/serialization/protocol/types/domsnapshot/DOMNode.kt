@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domsnapshot
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.dom.PseudoType
import ai.platon.cdt.kt.serialization.protocol.types.dom.ShadowRootType
import ai.platon.cdt.kt.serialization.protocol.types.domdebugger.EventListener
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * A Node in the DOM tree.
 */
@Serializable
data class DOMNode(
  @SerialName("nodeType")
  val nodeType: Int,
  @SerialName("nodeName")
  val nodeName: String,
  @SerialName("nodeValue")
  val nodeValue: String,
  @SerialName("textValue")
  @param:Optional
  val textValue: String? = null,
  @SerialName("inputValue")
  @param:Optional
  val inputValue: String? = null,
  @SerialName("inputChecked")
  @param:Optional
  val inputChecked: Boolean? = null,
  @SerialName("optionSelected")
  @param:Optional
  val optionSelected: Boolean? = null,
  @SerialName("backendNodeId")
  val backendNodeId: Int,
  @SerialName("childNodeIndexes")
  @param:Optional
  val childNodeIndexes: List<Int>? = null,
  @SerialName("attributes")
  @param:Optional
  val attributes: List<NameValue>? = null,
  @SerialName("pseudoElementIndexes")
  @param:Optional
  val pseudoElementIndexes: List<Int>? = null,
  @SerialName("layoutNodeIndex")
  @param:Optional
  val layoutNodeIndex: Int? = null,
  @SerialName("documentURL")
  @param:Optional
  val documentURL: String? = null,
  @SerialName("baseURL")
  @param:Optional
  val baseURL: String? = null,
  @SerialName("contentLanguage")
  @param:Optional
  val contentLanguage: String? = null,
  @SerialName("documentEncoding")
  @param:Optional
  val documentEncoding: String? = null,
  @SerialName("publicId")
  @param:Optional
  val publicId: String? = null,
  @SerialName("systemId")
  @param:Optional
  val systemId: String? = null,
  @SerialName("frameId")
  @param:Optional
  val frameId: String? = null,
  @SerialName("contentDocumentIndex")
  @param:Optional
  val contentDocumentIndex: Int? = null,
  @SerialName("pseudoType")
  @param:Optional
  val pseudoType: PseudoType? = null,
  @SerialName("shadowRootType")
  @param:Optional
  val shadowRootType: ShadowRootType? = null,
  @SerialName("isClickable")
  @param:Optional
  val isClickable: Boolean? = null,
  @SerialName("eventListeners")
  @param:Optional
  val eventListeners: List<EventListener>? = null,
  @SerialName("currentSourceURL")
  @param:Optional
  val currentSourceURL: String? = null,
  @SerialName("originURL")
  @param:Optional
  val originURL: String? = null,
  @SerialName("scrollOffsetX")
  @param:Optional
  val scrollOffsetX: Double? = null,
  @SerialName("scrollOffsetY")
  @param:Optional
  val scrollOffsetY: Double? = null,
)
