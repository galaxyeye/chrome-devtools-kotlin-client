@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int

/**
 * Fired when `Container`'s child node count has changed.
 */
@Serializable
data class ChildNodeCountUpdated(
  @SerialName("nodeId")
  val nodeId: Int,
  @SerialName("childNodeCount")
  val childNodeCount: Int,
)
