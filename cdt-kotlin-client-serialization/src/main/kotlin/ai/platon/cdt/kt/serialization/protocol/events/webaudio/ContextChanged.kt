@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webaudio

import ai.platon.cdt.kt.serialization.protocol.types.webaudio.BaseAudioContext
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Notifies that existing BaseAudioContext has changed some properties (id stays the same)..
 */
@Serializable
data class ContextChanged(
  @property:SerialName("context")
  val context: BaseAudioContext,
)
