package ai.platon.cdt.kt.protocol.events.media

import ai.platon.cdt.kt.protocol.types.media.PlayerError
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * Send a list of any errors that need to be delivered.
 */
public data class PlayerErrorsRaised(
  @field:JsonProperty("playerId")
  public val playerId: String,
  @field:JsonProperty("errors")
  public val errors: List<PlayerError>,
)
