@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.target

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.target.TargetInfo
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Issued when attached to target because of auto-attach or `attachToTarget` command.
 */
@Serializable
@Experimental
data class AttachedToTarget(
  @property:SerialName("sessionId")
  val sessionId: String,
  @property:SerialName("targetInfo")
  val targetInfo: TargetInfo,
  @property:SerialName("waitingForDebugger")
  val waitingForDebugger: Boolean,
)
