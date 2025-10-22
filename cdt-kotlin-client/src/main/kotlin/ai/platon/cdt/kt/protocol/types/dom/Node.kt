package ai.platon.cdt.kt.protocol.types.dom

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import java.lang.Deprecated
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * DOM interaction is implemented in terms of mirror objects that represent the actual DOM nodes.
 * DOMNode is a base node mirror type.
 */
data class Node(
  @field:JsonProperty("nodeId")
  val nodeId: Int,
  @field:JsonProperty("parentId")
  @param:Optional
  val parentId: Int? = null,
  @field:JsonProperty("backendNodeId")
  val backendNodeId: Int,
  @field:JsonProperty("nodeType")
  val nodeType: Int,
  @field:JsonProperty("nodeName")
  val nodeName: String,
  @field:JsonProperty("localName")
  val localName: String,
  @field:JsonProperty("nodeValue")
  val nodeValue: String,
  @field:JsonProperty("childNodeCount")
  @param:Optional
  val childNodeCount: Int? = null,
  @field:JsonProperty("children")
  @param:Optional
  val children: List<Node>? = null,
  @field:JsonProperty("attributes")
  @param:Optional
  val attributes: List<String>? = null,
  @field:JsonProperty("documentURL")
  @param:Optional
  val documentURL: String? = null,
  @field:JsonProperty("baseURL")
  @param:Optional
  val baseURL: String? = null,
  @field:JsonProperty("publicId")
  @param:Optional
  val publicId: String? = null,
  @field:JsonProperty("systemId")
  @param:Optional
  val systemId: String? = null,
  @field:JsonProperty("internalSubset")
  @param:Optional
  val internalSubset: String? = null,
  @field:JsonProperty("xmlVersion")
  @param:Optional
  val xmlVersion: String? = null,
  @field:JsonProperty("name")
  @param:Optional
  val name: String? = null,
  @field:JsonProperty("value")
  @param:Optional
  val `value`: String? = null,
  @field:JsonProperty("pseudoType")
  @param:Optional
  val pseudoType: PseudoType? = null,
  @field:JsonProperty("shadowRootType")
  @param:Optional
  val shadowRootType: ShadowRootType? = null,
  @field:JsonProperty("frameId")
  @param:Optional
  val frameId: String? = null,
  @field:JsonProperty("contentDocument")
  @param:Optional
  val contentDocument: Node? = null,
  @field:JsonProperty("shadowRoots")
  @param:Optional
  val shadowRoots: List<Node>? = null,
  @field:JsonProperty("templateContent")
  @param:Optional
  val templateContent: Node? = null,
  @field:JsonProperty("pseudoElements")
  @param:Optional
  val pseudoElements: List<Node>? = null,
  @field:JsonProperty("importedDocument")
  @param:Optional
  @param:Deprecated
  val importedDocument: Node? = null,
  @field:JsonProperty("distributedNodes")
  @param:Optional
  val distributedNodes: List<BackendNode>? = null,
  @field:JsonProperty("isSVG")
  @param:Optional
  val isSVG: Boolean? = null,
)
