@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webaudio
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.webaudio.BaseAudioContext

/**
 * Notifies that existing BaseAudioContext has changed some properties (id stays the same)..
 */
@Serializable
data class ContextChanged(
  @SerialName("context")
  val context: BaseAudioContext,
)
