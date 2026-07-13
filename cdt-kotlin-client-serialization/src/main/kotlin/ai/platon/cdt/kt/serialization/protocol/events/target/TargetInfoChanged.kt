@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.target

import ai.platon.cdt.kt.serialization.protocol.types.target.TargetInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Issued when some information about a target has changed. This only happens between
 * `targetCreated` and `targetDestroyed`.
 */
@Serializable
data class TargetInfoChanged(
  @property:SerialName("targetInfo")
  val targetInfo: TargetInfo,
)
