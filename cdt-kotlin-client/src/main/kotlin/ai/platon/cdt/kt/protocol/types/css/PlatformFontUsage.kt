package ai.platon.cdt.kt.protocol.types.css

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.String

/**
 * Information about amount of glyphs that were rendered with given font.
 */
data class PlatformFontUsage(
  @field:JsonProperty("familyName")
  val familyName: String,
  @field:JsonProperty("isCustomFont")
  val isCustomFont: Boolean,
  @field:JsonProperty("glyphCount")
  val glyphCount: Double,
)
