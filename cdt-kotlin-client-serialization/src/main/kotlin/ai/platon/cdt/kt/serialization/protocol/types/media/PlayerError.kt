@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.media
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * Corresponds to kMediaError
 */
@Serializable
data class PlayerError(
  @SerialName("type")
  val type: PlayerErrorType,
  @SerialName("errorCode")
  val errorCode: String,
)
