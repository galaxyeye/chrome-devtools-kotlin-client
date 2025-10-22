package ai.platon.cdt.kt.protocol.events.webaudio

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Notifies that a new AudioListener has been created.
 */
data class AudioListenerWillBeDestroyed(
  @field:JsonProperty("contextId")
  val contextId: String,
  @field:JsonProperty("listenerId")
  val listenerId: String,
)
