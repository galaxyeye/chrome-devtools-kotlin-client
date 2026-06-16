@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webaudio

import ai.platon.cdt.kt.serialization.protocol.types.webaudio.AudioListener
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Notifies that the construction of an AudioListener has finished.
 */
@Serializable
data class AudioListenerCreated(
  @property:SerialName("listener")
  val listener: AudioListener,
)
