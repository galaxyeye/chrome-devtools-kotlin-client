@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.dom

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Int

/**
 * Fired when a node's starting styles changes.
 */
@Experimental
data class AffectedByStartingStylesFlagUpdated(
  @param:JsonProperty("nodeId")
  val nodeId: Int,
  @param:JsonProperty("affectedByStartingStyles")
  val affectedByStartingStyles: Boolean,
)
