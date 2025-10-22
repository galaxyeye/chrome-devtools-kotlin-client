package ai.platon.cdt.kt.protocol.events.webaudio

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Notifies that an existing AudioParam has been destroyed.
 */
public data class AudioParamWillBeDestroyed(
  @field:JsonProperty("contextId")
  public val contextId: String,
  @field:JsonProperty("nodeId")
  public val nodeId: String,
  @field:JsonProperty("paramId")
  public val paramId: String,
)
