@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.network.ChallengeEventDetails
import ai.platon.cdt.kt.protocol.types.network.CreationEventDetails
import ai.platon.cdt.kt.protocol.types.network.RefreshEventDetails
import ai.platon.cdt.kt.protocol.types.network.TerminationEventDetails
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * Triggered when a device bound session event occurs.
 */
@Experimental
data class DeviceBoundSessionEventOccurred(
  @param:JsonProperty("eventId")
  val eventId: String,
  @param:JsonProperty("site")
  val site: String,
  @param:JsonProperty("succeeded")
  val succeeded: Boolean,
  @param:JsonProperty("sessionId")
  @param:Optional
  val sessionId: String? = null,
  @param:JsonProperty("creationEventDetails")
  @param:Optional
  val creationEventDetails: CreationEventDetails? = null,
  @param:JsonProperty("refreshEventDetails")
  @param:Optional
  val refreshEventDetails: RefreshEventDetails? = null,
  @param:JsonProperty("terminationEventDetails")
  @param:Optional
  val terminationEventDetails: TerminationEventDetails? = null,
  @param:JsonProperty("challengeEventDetails")
  @param:Optional
  val challengeEventDetails: ChallengeEventDetails? = null,
)
