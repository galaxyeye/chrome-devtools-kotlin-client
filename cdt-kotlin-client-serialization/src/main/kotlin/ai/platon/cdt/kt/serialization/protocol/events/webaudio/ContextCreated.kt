@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webaudio
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.webaudio.BaseAudioContext

/**
 * Notifies that a new BaseAudioContext has been created.
 */
@Serializable
data class ContextCreated(
  @SerialName("context")
  val context: BaseAudioContext,
)
