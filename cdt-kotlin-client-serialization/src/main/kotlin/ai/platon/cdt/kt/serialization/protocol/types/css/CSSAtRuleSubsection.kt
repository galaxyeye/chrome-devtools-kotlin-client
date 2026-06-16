@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Subsection of font-feature-values, if this is a subsection.
 */
@Serializable
public enum class CSSAtRuleSubsection {
  @SerialName("swash")
  SWASH,
  @SerialName("annotation")
  ANNOTATION,
  @SerialName("ornaments")
  ORNAMENTS,
  @SerialName("stylistic")
  STYLISTIC,
  @SerialName("styleset")
  STYLESET,
  @SerialName("character-variant")
  CHARACTER_VARIANT,
  UNKNOWN,
}
