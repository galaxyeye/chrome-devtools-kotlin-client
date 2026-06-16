@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.css

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Type of at-rule.
 */
public enum class CSSAtRuleType {
  @JsonProperty("font-face")
  FONT_FACE,
  @JsonProperty("font-feature-values")
  FONT_FEATURE_VALUES,
  @JsonProperty("font-palette-values")
  FONT_PALETTE_VALUES,
  @JsonProperty("counter-style")
  COUNTER_STYLE,
  @JsonEnumDefaultValue
  UNKNOWN,
}
