package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * Properties of a web font: https://www.w3.org/TR/2008/REC-CSS2-20080411/fonts.html#font-descriptions
 * and additional information such as platformFontFamily and fontVariationAxes.
 */
data class FontFace(
  @field:JsonProperty("fontFamily")
  val fontFamily: String,
  @field:JsonProperty("fontStyle")
  val fontStyle: String,
  @field:JsonProperty("fontVariant")
  val fontVariant: String,
  @field:JsonProperty("fontWeight")
  val fontWeight: String,
  @field:JsonProperty("fontStretch")
  val fontStretch: String,
  @field:JsonProperty("unicodeRange")
  val unicodeRange: String,
  @field:JsonProperty("src")
  val src: String,
  @field:JsonProperty("platformFontFamily")
  val platformFontFamily: String,
  @field:JsonProperty("fontVariationAxes")
  @param:Optional
  val fontVariationAxes: List<FontVariationAxis>? = null,
)
