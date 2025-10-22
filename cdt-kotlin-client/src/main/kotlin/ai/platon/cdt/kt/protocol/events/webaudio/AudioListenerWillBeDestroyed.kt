package ai.platon.cdt.kt.protocol.events.webaudio

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Notifies that a new AudioListener has been created.
 */
public data class AudioListenerWillBeDestroyed(
  @field:JsonProperty("contextId")
  public val contextId: String,
  @field:JsonProperty("listenerId")
  public val listenerId: String,
)
