@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.media

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Corresponds to kMediaError
 */
@Serializable
data class PlayerError(
  @property:SerialName("type")
  val type: PlayerErrorType,
  @property:SerialName("errorCode")
  val errorCode: String,
)
