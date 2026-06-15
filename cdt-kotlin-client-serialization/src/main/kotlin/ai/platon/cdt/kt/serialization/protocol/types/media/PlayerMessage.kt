@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.media
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * Have one type per entry in MediaLogRecord::Type
 * Corresponds to kMessage
 */
@Serializable
data class PlayerMessage(
  @SerialName("level")
  val level: PlayerMessageLevel,
  @SerialName("message")
  val message: String,
)
