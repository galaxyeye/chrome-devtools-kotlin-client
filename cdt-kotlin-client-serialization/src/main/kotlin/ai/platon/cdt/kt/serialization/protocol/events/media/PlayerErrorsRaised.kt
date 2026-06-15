@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.media
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.media.PlayerError
import kotlin.String
import kotlin.collections.List

/**
 * Send a list of any errors that need to be delivered.
 */
@Serializable
data class PlayerErrorsRaised(
  @SerialName("playerId")
  val playerId: String,
  @SerialName("errors")
  val errors: List<PlayerError>,
)
