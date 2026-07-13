@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Session event details specific to termination.
 */
@Serializable
@Experimental
data class TerminationEventDetails(
  @property:SerialName("deletionReason")
  val deletionReason: TerminationEventDetailsDeletionReason,
)
