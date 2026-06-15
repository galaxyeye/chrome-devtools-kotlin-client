@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webaudio
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.webaudio.AudioNode

/**
 * Notifies that a new AudioNode has been created.
 */
@Serializable
data class AudioNodeCreated(
  @SerialName("node")
  val node: AudioNode,
)
