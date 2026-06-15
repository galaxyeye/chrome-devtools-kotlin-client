@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webaudio
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.webaudio.AudioListener

/**
 * Notifies that the construction of an AudioListener has finished.
 */
@Serializable
data class AudioListenerCreated(
  @SerialName("listener")
  val listener: AudioListener,
)
