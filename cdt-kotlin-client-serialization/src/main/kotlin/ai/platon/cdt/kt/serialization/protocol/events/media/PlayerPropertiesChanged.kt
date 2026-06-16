@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.media

import ai.platon.cdt.kt.serialization.protocol.types.media.PlayerProperty
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This can be called multiple times, and can be used to set / override /
 * remove player properties. A null propValue indicates removal.
 */
@Serializable
data class PlayerPropertiesChanged(
  @property:SerialName("playerId")
  val playerId: String,
  @property:SerialName("properties")
  val properties: List<PlayerProperty>,
)
