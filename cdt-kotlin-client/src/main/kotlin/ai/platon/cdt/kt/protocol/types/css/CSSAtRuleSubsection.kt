@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.css

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Subsection of font-feature-values, if this is a subsection.
 */
public enum class CSSAtRuleSubsection {
  @JsonProperty("swash")
  SWASH,
  @JsonProperty("annotation")
  ANNOTATION,
  @JsonProperty("ornaments")
  ORNAMENTS,
  @JsonProperty("stylistic")
  STYLISTIC,
  @JsonProperty("styleset")
  STYLESET,
  @JsonProperty("character-variant")
  CHARACTER_VARIANT,
  @JsonEnumDefaultValue
  UNKNOWN,
}
