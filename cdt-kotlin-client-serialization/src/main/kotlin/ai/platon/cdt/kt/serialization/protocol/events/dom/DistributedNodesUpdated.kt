@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.dom.BackendNode
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Called when distribution is changed.
 */
@Serializable
@Experimental
data class DistributedNodesUpdated(
  @property:SerialName("insertionPointId")
  val insertionPointId: Int,
  @property:SerialName("distributedNodes")
  val distributedNodes: List<BackendNode>,
)
