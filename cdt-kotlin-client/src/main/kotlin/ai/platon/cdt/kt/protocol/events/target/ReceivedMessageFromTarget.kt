package ai.platon.cdt.kt.protocol.events.target

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import java.lang.Deprecated
import kotlin.String

/**
 * Notifies about a new protocol message received from the session (as reported in
 * `attachedToTarget` event).
 */
data class ReceivedMessageFromTarget(
  @field:JsonProperty("sessionId")
  val sessionId: String,
  @field:JsonProperty("message")
  val message: String,
  @field:JsonProperty("targetId")
  @param:Optional
  @param:Deprecated
  val targetId: String? = null,
)
