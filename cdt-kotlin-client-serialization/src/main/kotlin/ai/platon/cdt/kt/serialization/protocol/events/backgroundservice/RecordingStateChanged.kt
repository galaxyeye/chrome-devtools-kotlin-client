@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.backgroundservice
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.backgroundservice.ServiceName
import kotlin.Boolean

/**
 * Called when the recording state for the service has been updated.
 */
@Serializable
data class RecordingStateChanged(
  @SerialName("isRecording")
  val isRecording: Boolean,
  @SerialName("service")
  val service: ServiceName,
)
