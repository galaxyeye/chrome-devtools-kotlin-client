package ai.platon.cdt.kt.protocol.types.domsnapshot

import ai.platon.cdt.kt.protocol.types.dom.Rect
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Details of post layout rendered text positions. The exact layout should not be regarded as
 * stable and may change between versions.
 */
data class InlineTextBox(
  @field:JsonProperty("boundingBox")
  val boundingBox: Rect,
  @field:JsonProperty("startCharacterIndex")
  val startCharacterIndex: Int,
  @field:JsonProperty("numCharacters")
  val numCharacters: Int,
)
