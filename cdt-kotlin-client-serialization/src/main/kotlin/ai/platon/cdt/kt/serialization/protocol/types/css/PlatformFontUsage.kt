@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Information about amount of glyphs that were rendered with given font.
 */
@Serializable
data class PlatformFontUsage(
  @property:SerialName("familyName")
  val familyName: String,
  @property:SerialName("isCustomFont")
  val isCustomFont: Boolean,
  @property:SerialName("glyphCount")
  val glyphCount: Double,
)
