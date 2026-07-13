@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webaudio

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Notifies that an existing AudioNode has been destroyed.
 */
@Serializable
data class AudioNodeWillBeDestroyed(
  @property:SerialName("contextId")
  val contextId: String,
  @property:SerialName("nodeId")
  val nodeId: String,
)
