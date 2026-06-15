@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List

/**
 * Properties of a web font: https://www.w3.org/TR/2008/REC-CSS2-20080411/fonts.html#font-descriptions
 * and additional information such as platformFontFamily and fontVariationAxes.
 */
@Serializable
data class FontFace(
  @SerialName("fontFamily")
  val fontFamily: String,
  @SerialName("fontStyle")
  val fontStyle: String,
  @SerialName("fontVariant")
  val fontVariant: String,
  @SerialName("fontWeight")
  val fontWeight: String,
  @SerialName("fontStretch")
  val fontStretch: String,
  @SerialName("unicodeRange")
  val unicodeRange: String,
  @SerialName("src")
  val src: String,
  @SerialName("platformFontFamily")
  val platformFontFamily: String,
  @SerialName("fontVariationAxes")
  @param:Optional
  val fontVariationAxes: List<FontVariationAxis>? = null,
)
