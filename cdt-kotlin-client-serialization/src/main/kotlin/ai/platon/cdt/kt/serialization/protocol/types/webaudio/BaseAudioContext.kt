@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webaudio
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.String

/**
 * Protocol object for BaseAudioContext
 */
@Serializable
data class BaseAudioContext(
  @SerialName("contextId")
  val contextId: String,
  @SerialName("contextType")
  val contextType: ContextType,
  @SerialName("contextState")
  val contextState: ContextState,
  @SerialName("realtimeData")
  @param:Optional
  val realtimeData: ContextRealtimeData? = null,
  @SerialName("callbackBufferSize")
  val callbackBufferSize: Double,
  @SerialName("maxOutputChannelCount")
  val maxOutputChannelCount: Double,
  @SerialName("sampleRate")
  val sampleRate: Double,
)
