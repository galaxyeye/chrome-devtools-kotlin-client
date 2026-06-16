@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Session event details specific to termination.
 */
@Experimental
data class TerminationEventDetails(
  @param:JsonProperty("deletionReason")
  val deletionReason: TerminationEventDetailsDeletionReason,
)
