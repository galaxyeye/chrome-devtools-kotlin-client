@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.media

import ai.platon.cdt.kt.serialization.protocol.types.media.PlayerError
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Send a list of any errors that need to be delivered.
 */
@Serializable
data class PlayerErrorsRaised(
  @property:SerialName("playerId")
  val playerId: String,
  @property:SerialName("errors")
  val errors: List<PlayerError>,
)
