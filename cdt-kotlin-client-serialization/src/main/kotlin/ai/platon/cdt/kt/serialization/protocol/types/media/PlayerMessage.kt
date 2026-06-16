@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.media

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Have one type per entry in MediaLogRecord::Type
 * Corresponds to kMessage
 */
@Serializable
data class PlayerMessage(
  @property:SerialName("level")
  val level: PlayerMessageLevel,
  @property:SerialName("message")
  val message: String,
)
