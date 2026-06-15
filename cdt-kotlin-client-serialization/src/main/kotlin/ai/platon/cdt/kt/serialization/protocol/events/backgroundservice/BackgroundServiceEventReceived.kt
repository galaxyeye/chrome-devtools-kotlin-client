@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.backgroundservice
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.backgroundservice.BackgroundServiceEvent

/**
 * Called with all existing backgroundServiceEvents when enabled, and all new
 * events afterwards if enabled and recording.
 */
@Serializable
data class BackgroundServiceEventReceived(
  @SerialName("backgroundServiceEvent")
  val backgroundServiceEvent: BackgroundServiceEvent,
)
