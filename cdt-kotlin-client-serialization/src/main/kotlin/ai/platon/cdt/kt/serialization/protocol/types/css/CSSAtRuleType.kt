@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Type of at-rule.
 */
@Serializable
public enum class CSSAtRuleType {
  @SerialName("font-face")
  FONT_FACE,
  @SerialName("font-feature-values")
  FONT_FEATURE_VALUES,
  @SerialName("font-palette-values")
  FONT_PALETTE_VALUES,
  @SerialName("counter-style")
  COUNTER_STYLE,
  UNKNOWN,
}
