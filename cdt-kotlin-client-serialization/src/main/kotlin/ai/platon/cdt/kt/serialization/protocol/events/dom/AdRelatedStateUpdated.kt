@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.network.AdProvenance
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when a node's ad related state changes.
 */
@Serializable
@Experimental
data class AdRelatedStateUpdated(
  @property:SerialName("nodeId")
  val nodeId: Int,
  @property:SerialName("adProvenance")
  @param:Optional
  val adProvenance: AdProvenance? = null,
)
