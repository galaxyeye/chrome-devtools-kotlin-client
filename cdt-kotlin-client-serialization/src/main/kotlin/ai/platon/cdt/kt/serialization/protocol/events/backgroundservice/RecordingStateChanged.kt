@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.backgroundservice

import ai.platon.cdt.kt.serialization.protocol.types.backgroundservice.ServiceName
import kotlin.Boolean
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Called when the recording state for the service has been updated.
 */
@Serializable
data class RecordingStateChanged(
  @property:SerialName("isRecording")
  val isRecording: Boolean,
  @property:SerialName("service")
  val service: ServiceName,
)
