@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webaudio

import ai.platon.cdt.kt.serialization.protocol.types.webaudio.BaseAudioContext
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Notifies that a new BaseAudioContext has been created.
 */
@Serializable
data class ContextCreated(
  @property:SerialName("context")
  val context: BaseAudioContext,
)
