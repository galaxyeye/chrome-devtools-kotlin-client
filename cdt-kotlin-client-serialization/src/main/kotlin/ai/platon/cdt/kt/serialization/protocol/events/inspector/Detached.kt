@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.inspector

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when remote debugging connection is about to be terminated. Contains detach reason.
 */
@Serializable
data class Detached(
  @property:SerialName("reason")
  val reason: String,
)
