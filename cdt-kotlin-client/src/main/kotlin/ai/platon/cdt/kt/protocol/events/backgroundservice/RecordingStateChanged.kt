package ai.platon.cdt.kt.protocol.events.backgroundservice

import ai.platon.cdt.kt.protocol.types.backgroundservice.ServiceName
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

/**
 * Called when the recording state for the service has been updated.
 */
public data class RecordingStateChanged(
  @field:JsonProperty("isRecording")
  public val isRecording: Boolean,
  @field:JsonProperty("service")
  public val service: ServiceName,
)
