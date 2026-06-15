@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.dom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Pseudo element type.
 */
@Serializable
public enum class PseudoType {
  @SerialName("first-line")
  FIRST_LINE,
  @SerialName("first-letter")
  FIRST_LETTER,
  @SerialName("before")
  BEFORE,
  @SerialName("after")
  AFTER,
  @SerialName("marker")
  MARKER,
  @SerialName("backdrop")
  BACKDROP,
  @SerialName("selection")
  SELECTION,
  @SerialName("target-text")
  TARGET_TEXT,
  @SerialName("spelling-error")
  SPELLING_ERROR,
  @SerialName("grammar-error")
  GRAMMAR_ERROR,
  @SerialName("first-line-inherited")
  FIRST_LINE_INHERITED,
  @SerialName("scrollbar")
  SCROLLBAR,
  @SerialName("scrollbar-thumb")
  SCROLLBAR_THUMB,
  @SerialName("scrollbar-button")
  SCROLLBAR_BUTTON,
  @SerialName("scrollbar-track")
  SCROLLBAR_TRACK,
  @SerialName("scrollbar-track-piece")
  SCROLLBAR_TRACK_PIECE,
  @SerialName("scrollbar-corner")
  SCROLLBAR_CORNER,
  @SerialName("resizer")
  RESIZER,
  @SerialName("input-list-button")
  INPUT_LIST_BUTTON,
}
