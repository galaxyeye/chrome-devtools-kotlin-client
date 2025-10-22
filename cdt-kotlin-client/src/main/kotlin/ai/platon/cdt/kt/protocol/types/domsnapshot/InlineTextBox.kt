package ai.platon.cdt.kt.protocol.types.domsnapshot

import ai.platon.cdt.kt.protocol.types.dom.Rect
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Details of post layout rendered text positions. The exact layout should not be regarded as
 * stable and may change between versions.
 */
public data class InlineTextBox(
  @field:JsonProperty("boundingBox")
  public val boundingBox: Rect,
  @field:JsonProperty("startCharacterIndex")
  public val startCharacterIndex: Int,
  @field:JsonProperty("numCharacters")
  public val numCharacters: Int,
)
