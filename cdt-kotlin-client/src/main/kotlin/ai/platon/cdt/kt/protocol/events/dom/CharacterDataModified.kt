package ai.platon.cdt.kt.protocol.events.dom

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Mirrors `DOMCharacterDataModified` event.
 */
data class CharacterDataModified(
  @field:JsonProperty("nodeId")
  val nodeId: Int,
  @field:JsonProperty("characterData")
  val characterData: String,
)
