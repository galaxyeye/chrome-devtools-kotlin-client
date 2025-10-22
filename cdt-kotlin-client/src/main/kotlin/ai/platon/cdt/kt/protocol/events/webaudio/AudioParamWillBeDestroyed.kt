package ai.platon.cdt.kt.protocol.events.webaudio

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Notifies that an existing AudioParam has been destroyed.
 */
data class AudioParamWillBeDestroyed(
  @field:JsonProperty("contextId")
  val contextId: String,
  @field:JsonProperty("nodeId")
  val nodeId: String,
  @field:JsonProperty("paramId")
  val paramId: String,
)
