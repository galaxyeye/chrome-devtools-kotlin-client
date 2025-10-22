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
public data class Node(
  @field:JsonProperty("nodeId")
  public val nodeId: Int,
  @field:JsonProperty("parentId")
  @param:Optional
  public val parentId: Int? = null,
  @field:JsonProperty("backendNodeId")
  public val backendNodeId: Int,
  @field:JsonProperty("nodeType")
  public val nodeType: Int,
  @field:JsonProperty("nodeName")
  public val nodeName: String,
  @field:JsonProperty("localName")
  public val localName: String,
  @field:JsonProperty("nodeValue")
  public val nodeValue: String,
  @field:JsonProperty("childNodeCount")
  @param:Optional
  public val childNodeCount: Int? = null,
  @field:JsonProperty("children")
  @param:Optional
  public val children: List<Node>? = null,
  @field:JsonProperty("attributes")
  @param:Optional
  public val attributes: List<String>? = null,
  @field:JsonProperty("documentURL")
  @param:Optional
  public val documentURL: String? = null,
  @field:JsonProperty("baseURL")
  @param:Optional
  public val baseURL: String? = null,
  @field:JsonProperty("publicId")
  @param:Optional
  public val publicId: String? = null,
  @field:JsonProperty("systemId")
  @param:Optional
  public val systemId: String? = null,
  @field:JsonProperty("internalSubset")
  @param:Optional
  public val internalSubset: String? = null,
  @field:JsonProperty("xmlVersion")
  @param:Optional
  public val xmlVersion: String? = null,
  @field:JsonProperty("name")
  @param:Optional
  public val name: String? = null,
  @field:JsonProperty("value")
  @param:Optional
  public val `value`: String? = null,
  @field:JsonProperty("pseudoType")
  @param:Optional
  public val pseudoType: PseudoType? = null,
  @field:JsonProperty("shadowRootType")
  @param:Optional
  public val shadowRootType: ShadowRootType? = null,
  @field:JsonProperty("frameId")
  @param:Optional
  public val frameId: String? = null,
  @field:JsonProperty("contentDocument")
  @param:Optional
  public val contentDocument: Node? = null,
  @field:JsonProperty("shadowRoots")
  @param:Optional
  public val shadowRoots: List<Node>? = null,
  @field:JsonProperty("templateContent")
  @param:Optional
  public val templateContent: Node? = null,
  @field:JsonProperty("pseudoElements")
  @param:Optional
  public val pseudoElements: List<Node>? = null,
  @field:JsonProperty("importedDocument")
  @param:Optional
  @param:Deprecated
  public val importedDocument: Node? = null,
  @field:JsonProperty("distributedNodes")
  @param:Optional
  public val distributedNodes: List<BackendNode>? = null,
  @field:JsonProperty("isSVG")
  @param:Optional
  public val isSVG: Boolean? = null,
)
