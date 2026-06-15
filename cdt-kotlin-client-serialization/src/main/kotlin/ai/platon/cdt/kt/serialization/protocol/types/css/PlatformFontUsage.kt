@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Boolean
import kotlin.Double
import kotlin.String

/**
 * Information about amount of glyphs that were rendered with given font.
 */
@Serializable
data class PlatformFontUsage(
  @SerialName("familyName")
  val familyName: String,
  @SerialName("isCustomFont")
  val isCustomFont: Boolean,
  @SerialName("glyphCount")
  val glyphCount: Double,
)
