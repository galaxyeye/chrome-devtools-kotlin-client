package ai.platon.cdt.kt.protocol.events.media

import ai.platon.cdt.kt.protocol.types.media.PlayerProperty
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * This can be called multiple times, and can be used to set / override /
 * remove player properties. A null propValue indicates removal.
 */
data class PlayerPropertiesChanged(
  @field:JsonProperty("playerId")
  val playerId: String,
  @field:JsonProperty("properties")
  val properties: List<PlayerProperty>,
)
