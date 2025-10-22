package ai.platon.cdt.kt.protocol.types.media

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Corresponds to kMediaError
 */
data class PlayerError(
  @field:JsonProperty("type")
  val type: PlayerErrorType,
  @field:JsonProperty("errorCode")
  val errorCode: String,
)
