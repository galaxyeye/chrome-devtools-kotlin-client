@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.media

import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

/**
 * Corresponds to kMediaError
 */
@Serializable
data class PlayerError(
  @property:SerialName("errorType")
  val errorType: String,
  @property:SerialName("code")
  val code: Int,
  @property:SerialName("stack")
  val stack: List<PlayerErrorSourceLocation>,
  @property:SerialName("cause")
  val cause: List<PlayerError>,
  @property:SerialName("data")
  val `data`: JsonObject?,
)
