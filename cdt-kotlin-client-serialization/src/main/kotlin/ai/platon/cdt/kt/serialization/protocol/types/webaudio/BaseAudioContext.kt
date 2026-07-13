@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webaudio

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Protocol object for BaseAudioContext
 */
@Serializable
data class BaseAudioContext(
  @property:SerialName("contextId")
  val contextId: String,
  @property:SerialName("contextType")
  val contextType: ContextType,
  @property:SerialName("contextState")
  val contextState: ContextState,
  @property:SerialName("realtimeData")
  @param:Optional
  val realtimeData: ContextRealtimeData? = null,
  @property:SerialName("callbackBufferSize")
  val callbackBufferSize: Double,
  @property:SerialName("maxOutputChannelCount")
  val maxOutputChannelCount: Double,
  @property:SerialName("sampleRate")
  val sampleRate: Double,
)
