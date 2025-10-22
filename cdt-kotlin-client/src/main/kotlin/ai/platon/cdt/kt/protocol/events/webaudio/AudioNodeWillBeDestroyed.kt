package ai.platon.cdt.kt.protocol.events.webaudio

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Notifies that an existing AudioNode has been destroyed.
 */
data class AudioNodeWillBeDestroyed(
  @field:JsonProperty("contextId")
  val contextId: String,
  @field:JsonProperty("nodeId")
  val nodeId: String,
)
