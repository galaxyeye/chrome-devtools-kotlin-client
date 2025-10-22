package ai.platon.cdt.kt.protocol.types.css

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.String

/**
 * Information about amount of glyphs that were rendered with given font.
 */
public data class PlatformFontUsage(
  @field:JsonProperty("familyName")
  public val familyName: String,
  @field:JsonProperty("isCustomFont")
  public val isCustomFont: Boolean,
  @field:JsonProperty("glyphCount")
  public val glyphCount: Double,
)
