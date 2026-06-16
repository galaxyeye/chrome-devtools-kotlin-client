@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Boolean
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when a node's starting styles changes.
 */
@Serializable
@Experimental
data class AffectedByStartingStylesFlagUpdated(
  @property:SerialName("nodeId")
  val nodeId: Int,
  @property:SerialName("affectedByStartingStyles")
  val affectedByStartingStyles: Boolean,
)
