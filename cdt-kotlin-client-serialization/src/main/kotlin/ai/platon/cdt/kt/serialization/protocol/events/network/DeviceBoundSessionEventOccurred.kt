@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.network.ChallengeEventDetails
import ai.platon.cdt.kt.serialization.protocol.types.network.CreationEventDetails
import ai.platon.cdt.kt.serialization.protocol.types.network.RefreshEventDetails
import ai.platon.cdt.kt.serialization.protocol.types.network.TerminationEventDetails
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Triggered when a device bound session event occurs.
 */
@Serializable
@Experimental
data class DeviceBoundSessionEventOccurred(
  @property:SerialName("eventId")
  val eventId: String,
  @property:SerialName("site")
  val site: String,
  @property:SerialName("succeeded")
  val succeeded: Boolean,
  @property:SerialName("sessionId")
  @param:Optional
  val sessionId: String? = null,
  @property:SerialName("creationEventDetails")
  @param:Optional
  val creationEventDetails: CreationEventDetails? = null,
  @property:SerialName("refreshEventDetails")
  @param:Optional
  val refreshEventDetails: RefreshEventDetails? = null,
  @property:SerialName("terminationEventDetails")
  @param:Optional
  val terminationEventDetails: TerminationEventDetails? = null,
  @property:SerialName("challengeEventDetails")
  @param:Optional
  val challengeEventDetails: ChallengeEventDetails? = null,
)
