@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.target

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Deprecated
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Notifies about a new protocol message received from the session (as reported in
 * `attachedToTarget` event).
 */
@Serializable
data class ReceivedMessageFromTarget(
  @property:SerialName("sessionId")
  val sessionId: String,
  @property:SerialName("message")
  val message: String,
  @property:SerialName("targetId")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val targetId: String? = null,
)
