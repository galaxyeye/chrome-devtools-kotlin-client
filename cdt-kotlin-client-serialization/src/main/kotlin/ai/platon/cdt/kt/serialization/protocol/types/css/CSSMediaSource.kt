@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Source of the media query: "mediaRule" if specified by a @media rule, "importRule" if
 * specified by an @import rule, "linkedSheet" if specified by a "media" attribute in a linked
 * stylesheet's LINK tag, "inlineSheet" if specified by a "media" attribute in an inline
 * stylesheet's STYLE tag.
 */
@Serializable
public enum class CSSMediaSource {
  @SerialName("mediaRule")
  MEDIA_RULE,
  @SerialName("importRule")
  IMPORT_RULE,
  @SerialName("linkedSheet")
  LINKED_SHEET,
  @SerialName("inlineSheet")
  INLINE_SHEET,
}
