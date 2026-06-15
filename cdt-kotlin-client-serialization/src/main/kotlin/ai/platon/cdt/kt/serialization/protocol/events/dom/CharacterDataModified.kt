@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int
import kotlin.String

/**
 * Mirrors `DOMCharacterDataModified` event.
 */
@Serializable
data class CharacterDataModified(
  @SerialName("nodeId")
  val nodeId: Int,
  @SerialName("characterData")
  val characterData: String,
)
