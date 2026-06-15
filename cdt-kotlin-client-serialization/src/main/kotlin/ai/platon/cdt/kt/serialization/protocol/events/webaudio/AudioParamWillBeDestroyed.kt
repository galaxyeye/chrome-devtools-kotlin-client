@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webaudio
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * Notifies that an existing AudioParam has been destroyed.
 */
@Serializable
data class AudioParamWillBeDestroyed(
  @SerialName("contextId")
  val contextId: String,
  @SerialName("nodeId")
  val nodeId: String,
  @SerialName("paramId")
  val paramId: String,
)
