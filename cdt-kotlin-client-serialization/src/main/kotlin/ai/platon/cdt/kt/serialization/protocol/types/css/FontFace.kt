@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Properties of a web font: https://www.w3.org/TR/2008/REC-CSS2-20080411/fonts.html#font-descriptions
 * and additional information such as platformFontFamily and fontVariationAxes.
 */
@Serializable
data class FontFace(
  @property:SerialName("fontFamily")
  val fontFamily: String,
  @property:SerialName("fontStyle")
  val fontStyle: String,
  @property:SerialName("fontVariant")
  val fontVariant: String,
  @property:SerialName("fontWeight")
  val fontWeight: String,
  @property:SerialName("fontStretch")
  val fontStretch: String,
  @property:SerialName("unicodeRange")
  val unicodeRange: String,
  @property:SerialName("src")
  val src: String,
  @property:SerialName("platformFontFamily")
  val platformFontFamily: String,
  @property:SerialName("fontVariationAxes")
  @param:Optional
  val fontVariationAxes: List<FontVariationAxis>? = null,
)
