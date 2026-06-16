@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webaudio

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Notifies that an existing BaseAudioContext will be destroyed.
 */
@Serializable
data class ContextWillBeDestroyed(
  @property:SerialName("contextId")
  val contextId: String,
)
