@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Mirrors `DOMCharacterDataModified` event.
 */
@Serializable
data class CharacterDataModified(
  @property:SerialName("nodeId")
  val nodeId: Int,
  @property:SerialName("characterData")
  val characterData: String,
)
