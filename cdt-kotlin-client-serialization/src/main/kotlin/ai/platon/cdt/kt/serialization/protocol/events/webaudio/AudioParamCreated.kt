@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webaudio

import ai.platon.cdt.kt.serialization.protocol.types.webaudio.AudioParam
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Notifies that a new AudioParam has been created.
 */
@Serializable
data class AudioParamCreated(
  @property:SerialName("param")
  val `param`: AudioParam,
)
