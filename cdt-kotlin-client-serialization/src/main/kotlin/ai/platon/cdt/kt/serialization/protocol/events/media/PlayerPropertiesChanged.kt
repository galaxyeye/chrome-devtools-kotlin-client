@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.media
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.media.PlayerProperty
import kotlin.String
import kotlin.collections.List

/**
 * This can be called multiple times, and can be used to set / override /
 * remove player properties. A null propValue indicates removal.
 */
@Serializable
data class PlayerPropertiesChanged(
  @SerialName("playerId")
  val playerId: String,
  @SerialName("properties")
  val properties: List<PlayerProperty>,
)
