@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Boolean
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when a node's scrollability state changes.
 */
@Serializable
@Experimental
data class ScrollableFlagUpdated(
  @property:SerialName("nodeId")
  val nodeId: Int,
  @property:SerialName("isScrollable")
  val isScrollable: Boolean,
)
