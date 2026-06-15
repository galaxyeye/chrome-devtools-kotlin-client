@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.dom.BackendNode
import kotlin.Int
import kotlin.collections.List

/**
 * Called when distribution is changed.
 */
@Experimental
@Serializable
data class DistributedNodesUpdated(
  @SerialName("insertionPointId")
  val insertionPointId: Int,
  @SerialName("distributedNodes")
  val distributedNodes: List<BackendNode>,
)
