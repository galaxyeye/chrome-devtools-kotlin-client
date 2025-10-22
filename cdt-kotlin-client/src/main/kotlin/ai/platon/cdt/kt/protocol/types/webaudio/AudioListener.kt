package ai.platon.cdt.kt.protocol.types.webaudio

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Protocol object for AudioListener
 */
data class AudioListener(
  @field:JsonProperty("listenerId")
  val listenerId: String,
  @field:JsonProperty("contextId")
  val contextId: String,
)
