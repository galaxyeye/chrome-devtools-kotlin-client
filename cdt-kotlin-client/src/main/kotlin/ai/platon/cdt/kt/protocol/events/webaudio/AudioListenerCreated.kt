package ai.platon.cdt.kt.protocol.events.webaudio

import ai.platon.cdt.kt.protocol.types.webaudio.AudioListener
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Notifies that the construction of an AudioListener has finished.
 */
data class AudioListenerCreated(
  @field:JsonProperty("listener")
  val listener: AudioListener,
)
