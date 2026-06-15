@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webaudio
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * Notifies that an existing AudioNode has been destroyed.
 */
@Serializable
data class AudioNodeWillBeDestroyed(
  @SerialName("contextId")
  val contextId: String,
  @SerialName("nodeId")
  val nodeId: String,
)
