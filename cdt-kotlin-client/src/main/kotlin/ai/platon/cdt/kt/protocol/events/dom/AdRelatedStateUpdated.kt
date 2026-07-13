@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.dom

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.network.AdProvenance
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Fired when a node's ad related state changes.
 */
@Experimental
data class AdRelatedStateUpdated(
  @param:JsonProperty("nodeId")
  val nodeId: Int,
  @param:JsonProperty("adProvenance")
  @param:Optional
  val adProvenance: AdProvenance? = null,
)
