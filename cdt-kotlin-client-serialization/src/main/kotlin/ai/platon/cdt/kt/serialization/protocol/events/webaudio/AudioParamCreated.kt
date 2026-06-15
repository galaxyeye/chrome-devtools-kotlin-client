@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webaudio
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.webaudio.AudioParam

/**
 * Notifies that a new AudioParam has been created.
 */
@Serializable
data class AudioParamCreated(
  @SerialName("param")
  val `param`: AudioParam,
)
