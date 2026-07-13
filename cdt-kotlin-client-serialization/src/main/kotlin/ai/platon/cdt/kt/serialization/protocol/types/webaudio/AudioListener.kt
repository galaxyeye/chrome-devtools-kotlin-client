@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webaudio

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Protocol object for AudioListener
 */
@Serializable
data class AudioListener(
  @property:SerialName("listenerId")
  val listenerId: String,
  @property:SerialName("contextId")
  val contextId: String,
)
