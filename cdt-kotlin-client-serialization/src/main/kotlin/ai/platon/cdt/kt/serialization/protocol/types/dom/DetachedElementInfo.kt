@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.dom

import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A structure to hold the top-level node of a detached tree and an array of its retained descendants.
 */
@Serializable
data class DetachedElementInfo(
  @property:SerialName("treeNode")
  val treeNode: Node,
  @property:SerialName("retainedNodeIds")
  val retainedNodeIds: List<Int>,
)
