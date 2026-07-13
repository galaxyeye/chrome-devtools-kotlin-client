@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.target

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Issued when a target is destroyed.
 */
@Serializable
data class TargetDestroyed(
  @property:SerialName("targetId")
  val targetId: String,
)
