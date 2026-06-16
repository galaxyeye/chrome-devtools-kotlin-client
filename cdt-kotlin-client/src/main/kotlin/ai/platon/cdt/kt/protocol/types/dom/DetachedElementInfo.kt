@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.dom

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.collections.List

/**
 * A structure to hold the top-level node of a detached tree and an array of its retained descendants.
 */
data class DetachedElementInfo(
  @param:JsonProperty("treeNode")
  val treeNode: Node,
  @param:JsonProperty("retainedNodeIds")
  val retainedNodeIds: List<Int>,
)
