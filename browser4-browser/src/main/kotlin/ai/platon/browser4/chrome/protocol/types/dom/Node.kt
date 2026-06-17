@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.dom

import ai.platon.browser4.chrome.protocol.support.annotations.Experimental
import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import ai.platon.browser4.chrome.protocol.types.network.AdProvenance
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * DOM interaction is implemented in terms of mirror objects that represent the actual DOM nodes.
 * DOMNode is a base node mirror type.
 */
@Serializable
data class Node(
  @property:SerialName("nodeId")
  val nodeId: Int,
  @property:SerialName("parentId")
  @param:Optional
  val parentId: Int? = null,
  @property:SerialName("backendNodeId")
  val backendNodeId: Int,
  @property:SerialName("nodeType")
  val nodeType: Int,
  @property:SerialName("nodeName")
  val nodeName: String,
  @property:SerialName("localName")
  val localName: String,
  @property:SerialName("nodeValue")
  val nodeValue: String,
  @property:SerialName("childNodeCount")
  @param:Optional
  val childNodeCount: Int? = null,
  @property:SerialName("children")
  @param:Optional
  val children: List<Node>? = null,
  @property:SerialName("attributes")
  @param:Optional
  val attributes: List<String>? = null,
  @property:SerialName("documentURL")
  @param:Optional
  val documentURL: String? = null,
  @property:SerialName("baseURL")
  @param:Optional
  val baseURL: String? = null,
  @property:SerialName("publicId")
  @param:Optional
  val publicId: String? = null,
  @property:SerialName("systemId")
  @param:Optional
  val systemId: String? = null,
  @property:SerialName("internalSubset")
  @param:Optional
  val internalSubset: String? = null,
  @property:SerialName("xmlVersion")
  @param:Optional
  val xmlVersion: String? = null,
  @property:SerialName("name")
  @param:Optional
  val name: String? = null,
  @property:SerialName("value")
  @param:Optional
  val `value`: String? = null,
  @property:SerialName("pseudoType")
  @param:Optional
  val pseudoType: PseudoType? = null,
  @property:SerialName("pseudoIdentifier")
  @param:Optional
  val pseudoIdentifier: String? = null,
  @property:SerialName("shadowRootType")
  @param:Optional
  val shadowRootType: ShadowRootType? = null,
  @property:SerialName("frameId")
  @param:Optional
  val frameId: String? = null,
  @property:SerialName("contentDocument")
  @param:Optional
  val contentDocument: Node? = null,
  @property:SerialName("shadowRoots")
  @param:Optional
  val shadowRoots: List<Node>? = null,
  @property:SerialName("templateContent")
  @param:Optional
  val templateContent: Node? = null,
  @property:SerialName("pseudoElements")
  @param:Optional
  val pseudoElements: List<Node>? = null,
  @property:SerialName("importedDocument")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val importedDocument: Node? = null,
  @property:SerialName("distributedNodes")
  @param:Optional
  val distributedNodes: List<BackendNode>? = null,
  @property:SerialName("isSVG")
  @param:Optional
  val isSVG: Boolean? = null,
  @property:SerialName("compatibilityMode")
  @param:Optional
  val compatibilityMode: CompatibilityMode? = null,
  @property:SerialName("assignedSlot")
  @param:Optional
  val assignedSlot: BackendNode? = null,
  @property:SerialName("isScrollable")
  @param:Optional
  @param:Experimental
  val isScrollable: Boolean? = null,
  @property:SerialName("affectedByStartingStyles")
  @param:Optional
  @param:Experimental
  val affectedByStartingStyles: Boolean? = null,
  @property:SerialName("adoptedStyleSheets")
  @param:Optional
  @param:Experimental
  val adoptedStyleSheets: List<String>? = null,
  @property:SerialName("adProvenance")
  @param:Optional
  @param:Experimental
  val adProvenance: AdProvenance? = null,
) {
  companion object {
    /** Fallback instance used when CDP deserialization fails due to protocol mismatch. */
    fun degraded(): Node = Node(
      nodeId = 0, backendNodeId = 0, nodeType = 0,
      nodeName = "", localName = "", nodeValue = ""
    )
  }
}
