package ai.platon.cdt.kt.protocol.events.target

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.types.target.TargetInfo
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * Issued when attached to target because of auto-attach or `attachToTarget` command.
 */
@Experimental
data class AttachedToTarget(
  @field:JsonProperty("sessionId")
  val sessionId: String,
  @field:JsonProperty("targetInfo")
  val targetInfo: TargetInfo,
  @field:JsonProperty("waitingForDebugger")
  val waitingForDebugger: Boolean,
)
