@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webaudio

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Notifies that a new AudioListener has been created.
 */
@Serializable
data class AudioListenerWillBeDestroyed(
  @property:SerialName("contextId")
  val contextId: String,
  @property:SerialName("listenerId")
  val listenerId: String,
)
