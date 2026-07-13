@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when `Container`'s child node count has changed.
 */
@Serializable
data class ChildNodeCountUpdated(
  @property:SerialName("nodeId")
  val nodeId: Int,
  @property:SerialName("childNodeCount")
  val childNodeCount: Int,
)
