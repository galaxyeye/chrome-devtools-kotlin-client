package ai.platon.cdt.kt.protocol.events.backgroundservice

import ai.platon.cdt.kt.protocol.types.backgroundservice.ServiceName
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

/**
 * Called when the recording state for the service has been updated.
 */
data class RecordingStateChanged(
  @field:JsonProperty("isRecording")
  val isRecording: Boolean,
  @field:JsonProperty("service")
  val service: ServiceName,
)
