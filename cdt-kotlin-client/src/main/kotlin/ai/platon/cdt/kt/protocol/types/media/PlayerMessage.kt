package ai.platon.cdt.kt.protocol.types.media

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Have one type per entry in MediaLogRecord::Type
 * Corresponds to kMessage
 */
public data class PlayerMessage(
  @field:JsonProperty("level")
  public val level: PlayerMessageLevel,
  @field:JsonProperty("message")
  public val message: String,
)
