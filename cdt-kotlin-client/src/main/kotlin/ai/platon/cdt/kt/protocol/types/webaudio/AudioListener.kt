package ai.platon.cdt.kt.protocol.types.webaudio

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Protocol object for AudioListener
 */
public data class AudioListener(
  @field:JsonProperty("listenerId")
  public val listenerId: String,
  @field:JsonProperty("contextId")
  public val contextId: String,
)
