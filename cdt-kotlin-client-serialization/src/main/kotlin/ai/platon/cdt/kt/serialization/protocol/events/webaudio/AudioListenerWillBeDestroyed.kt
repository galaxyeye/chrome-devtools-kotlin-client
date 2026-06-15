@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webaudio
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * Notifies that a new AudioListener has been created.
 */
@Serializable
data class AudioListenerWillBeDestroyed(
  @SerialName("contextId")
  val contextId: String,
  @SerialName("listenerId")
  val listenerId: String,
)
