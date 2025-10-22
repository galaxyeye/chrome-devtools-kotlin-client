package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * Properties of a web font:
 * https://www.w3.org/TR/2008/REC-CSS2-20080411/fonts.html#font-descriptions
 * and additional information such as platformFontFamily and fontVariationAxes.
 */
public data class FontFace(
  @field:JsonProperty("fontFamily")
  public val fontFamily: String,
  @field:JsonProperty("fontStyle")
  public val fontStyle: String,
  @field:JsonProperty("fontVariant")
  public val fontVariant: String,
  @field:JsonProperty("fontWeight")
  public val fontWeight: String,
  @field:JsonProperty("fontStretch")
  public val fontStretch: String,
  @field:JsonProperty("unicodeRange")
  public val unicodeRange: String,
  @field:JsonProperty("src")
  public val src: String,
  @field:JsonProperty("platformFontFamily")
  public val platformFontFamily: String,
  @field:JsonProperty("fontVariationAxes")
  @param:Optional
  public val fontVariationAxes: List<FontVariationAxis>? = null,
)
