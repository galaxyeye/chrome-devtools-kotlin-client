@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.inspector
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * Fired when remote debugging connection is about to be terminated. Contains detach reason.
 */
@Serializable
data class Detached(
  @SerialName("reason")
  val reason: String,
)
