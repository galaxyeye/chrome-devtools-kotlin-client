package ai.platon.cdt.kt.protocol.types.webaudio

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Protocol object for BaseAudioContext
 */
data class BaseAudioContext(
  @field:JsonProperty("contextId")
  val contextId: String,
  @field:JsonProperty("contextType")
  val contextType: ContextType,
  @field:JsonProperty("contextState")
  val contextState: ContextState,
  @field:JsonProperty("realtimeData")
  @param:Optional
  val realtimeData: ContextRealtimeData? = null,
  @field:JsonProperty("callbackBufferSize")
  val callbackBufferSize: Double,
  @field:JsonProperty("maxOutputChannelCount")
  val maxOutputChannelCount: Double,
  @field:JsonProperty("sampleRate")
  val sampleRate: Double,
)
