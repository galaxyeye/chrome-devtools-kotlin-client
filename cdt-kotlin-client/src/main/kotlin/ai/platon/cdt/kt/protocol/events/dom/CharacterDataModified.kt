package ai.platon.cdt.kt.protocol.events.dom

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Mirrors `DOMCharacterDataModified` event.
 */
public data class CharacterDataModified(
  @field:JsonProperty("nodeId")
  public val nodeId: Int,
  @field:JsonProperty("characterData")
  public val characterData: String,
)
