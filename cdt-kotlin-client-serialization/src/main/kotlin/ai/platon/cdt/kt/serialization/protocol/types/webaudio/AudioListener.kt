@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webaudio
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * Protocol object for AudioListener
 */
@Serializable
data class AudioListener(
  @SerialName("listenerId")
  val listenerId: String,
  @SerialName("contextId")
  val contextId: String,
)
