package ai.platon.cdt.kt.protocol.events.webaudio

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Notifies that an existing AudioNode has been destroyed.
 */
public data class AudioNodeWillBeDestroyed(
  @field:JsonProperty("contextId")
  public val contextId: String,
  @field:JsonProperty("nodeId")
  public val nodeId: String,
)
