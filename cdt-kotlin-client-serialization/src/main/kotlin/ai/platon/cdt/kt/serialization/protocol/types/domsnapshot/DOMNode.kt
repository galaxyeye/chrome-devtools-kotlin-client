@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domsnapshot

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.dom.PseudoType
import ai.platon.cdt.kt.serialization.protocol.types.dom.ShadowRootType
import ai.platon.cdt.kt.serialization.protocol.types.domdebugger.EventListener
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A Node in the DOM tree.
 */
@Serializable
data class DOMNode(
  @property:SerialName("nodeType")
  val nodeType: Int,
  @property:SerialName("nodeName")
  val nodeName: String,
  @property:SerialName("nodeValue")
  val nodeValue: String,
  @property:SerialName("textValue")
  @param:Optional
  val textValue: String? = null,
  @property:SerialName("inputValue")
  @param:Optional
  val inputValue: String? = null,
  @property:SerialName("inputChecked")
  @param:Optional
  val inputChecked: Boolean? = null,
  @property:SerialName("optionSelected")
  @param:Optional
  val optionSelected: Boolean? = null,
  @property:SerialName("backendNodeId")
  val backendNodeId: Int,
  @property:SerialName("childNodeIndexes")
  @param:Optional
  val childNodeIndexes: List<Int>? = null,
  @property:SerialName("attributes")
  @param:Optional
  val attributes: List<NameValue>? = null,
  @property:SerialName("pseudoElementIndexes")
  @param:Optional
  val pseudoElementIndexes: List<Int>? = null,
  @property:SerialName("layoutNodeIndex")
  @param:Optional
  val layoutNodeIndex: Int? = null,
  @property:SerialName("documentURL")
  @param:Optional
  val documentURL: String? = null,
  @property:SerialName("baseURL")
  @param:Optional
  val baseURL: String? = null,
  @property:SerialName("contentLanguage")
  @param:Optional
  val contentLanguage: String? = null,
  @property:SerialName("documentEncoding")
  @param:Optional
  val documentEncoding: String? = null,
  @property:SerialName("publicId")
  @param:Optional
  val publicId: String? = null,
  @property:SerialName("systemId")
  @param:Optional
  val systemId: String? = null,
  @property:SerialName("frameId")
  @param:Optional
  val frameId: String? = null,
  @property:SerialName("contentDocumentIndex")
  @param:Optional
  val contentDocumentIndex: Int? = null,
  @property:SerialName("pseudoType")
  @param:Optional
  val pseudoType: PseudoType? = null,
  @property:SerialName("shadowRootType")
  @param:Optional
  val shadowRootType: ShadowRootType? = null,
  @property:SerialName("isClickable")
  @param:Optional
  val isClickable: Boolean? = null,
  @property:SerialName("eventListeners")
  @param:Optional
  val eventListeners: List<EventListener>? = null,
  @property:SerialName("currentSourceURL")
  @param:Optional
  val currentSourceURL: String? = null,
  @property:SerialName("originURL")
  @param:Optional
  val originURL: String? = null,
  @property:SerialName("scrollOffsetX")
  @param:Optional
  val scrollOffsetX: Double? = null,
  @property:SerialName("scrollOffsetY")
  @param:Optional
  val scrollOffsetY: Double? = null,
)
