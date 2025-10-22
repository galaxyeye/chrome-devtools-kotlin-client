package ai.platon.cdt.kt.protocol.types.webaudio

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Protocol object for BaseAudioContext
 */
public data class BaseAudioContext(
  @field:JsonProperty("contextId")
  public val contextId: String,
  @field:JsonProperty("contextType")
  public val contextType: ContextType,
  @field:JsonProperty("contextState")
  public val contextState: ContextState,
  @field:JsonProperty("realtimeData")
  @param:Optional
  public val realtimeData: ContextRealtimeData? = null,
  @field:JsonProperty("callbackBufferSize")
  public val callbackBufferSize: Double,
  @field:JsonProperty("maxOutputChannelCount")
  public val maxOutputChannelCount: Double,
  @field:JsonProperty("sampleRate")
  public val sampleRate: Double,
)
