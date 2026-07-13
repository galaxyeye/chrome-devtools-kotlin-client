@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webaudio

import ai.platon.cdt.kt.serialization.protocol.types.webaudio.AudioNode
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Notifies that a new AudioNode has been created.
 */
@Serializable
data class AudioNodeCreated(
  @property:SerialName("node")
  val node: AudioNode,
)
