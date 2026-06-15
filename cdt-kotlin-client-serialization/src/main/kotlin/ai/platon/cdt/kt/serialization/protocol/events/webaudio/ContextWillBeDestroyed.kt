@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webaudio
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * Notifies that an existing BaseAudioContext will be destroyed.
 */
@Serializable
data class ContextWillBeDestroyed(
  @SerialName("contextId")
  val contextId: String,
)
