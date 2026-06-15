@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.dom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * DOM interaction is implemented in terms of mirror objects that represent the actual DOM nodes.
 * DOMNode is a base node mirror type.
 */
@Serializable
data class Node(
  @SerialName("nodeId")
  val nodeId: Int,
  @SerialName("parentId")
  @param:Optional
  val parentId: Int? = null,
  @SerialName("backendNodeId")
  val backendNodeId: Int,
  @SerialName("nodeType")
  val nodeType: Int,
  @SerialName("nodeName")
  val nodeName: String,
  @SerialName("localName")
  val localName: String,
  @SerialName("nodeValue")
  val nodeValue: String,
  @SerialName("childNodeCount")
  @param:Optional
  val childNodeCount: Int? = null,
  @SerialName("children")
  @param:Optional
  val children: List<Node>? = null,
  @SerialName("attributes")
  @param:Optional
  val attributes: List<String>? = null,
  @SerialName("documentURL")
  @param:Optional
  val documentURL: String? = null,
  @SerialName("baseURL")
  @param:Optional
  val baseURL: String? = null,
  @SerialName("publicId")
  @param:Optional
  val publicId: String? = null,
  @SerialName("systemId")
  @param:Optional
  val systemId: String? = null,
  @SerialName("internalSubset")
  @param:Optional
  val internalSubset: String? = null,
  @SerialName("xmlVersion")
  @param:Optional
  val xmlVersion: String? = null,
  @SerialName("name")
  @param:Optional
  val name: String? = null,
  @SerialName("value")
  @param:Optional
  val `value`: String? = null,
  @SerialName("pseudoType")
  @param:Optional
  val pseudoType: PseudoType? = null,
  @SerialName("shadowRootType")
  @param:Optional
  val shadowRootType: ShadowRootType? = null,
  @SerialName("frameId")
  @param:Optional
  val frameId: String? = null,
  @SerialName("contentDocument")
  @param:Optional
  val contentDocument: Node? = null,
  @SerialName("shadowRoots")
  @param:Optional
  val shadowRoots: List<Node>? = null,
  @SerialName("templateContent")
  @param:Optional
  val templateContent: Node? = null,
  @SerialName("pseudoElements")
  @param:Optional
  val pseudoElements: List<Node>? = null,
  @SerialName("importedDocument")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val importedDocument: Node? = null,
  @SerialName("distributedNodes")
  @param:Optional
  val distributedNodes: List<BackendNode>? = null,
  @SerialName("isSVG")
  @param:Optional
  val isSVG: Boolean? = null,
)
