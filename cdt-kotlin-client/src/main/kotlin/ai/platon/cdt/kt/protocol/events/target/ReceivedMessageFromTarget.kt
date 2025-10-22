package ai.platon.cdt.kt.protocol.events.target

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import java.lang.Deprecated
import kotlin.String

/**
 * Notifies about a new protocol message received from the session (as reported in
 * `attachedToTarget` event).
 */
public data class ReceivedMessageFromTarget(
  @field:JsonProperty("sessionId")
  public val sessionId: String,
  @field:JsonProperty("message")
  public val message: String,
  @field:JsonProperty("targetId")
  @param:Optional
  @param:Deprecated
  public val targetId: String? = null,
)
