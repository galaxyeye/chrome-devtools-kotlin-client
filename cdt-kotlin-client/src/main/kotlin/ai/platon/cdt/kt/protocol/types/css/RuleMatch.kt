package ai.platon.cdt.kt.protocol.types.css

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.collections.List

/**
 * Match data for a CSS rule.
 */
data class RuleMatch(
  @field:JsonProperty("rule")
  val rule: CSSRule,
  @field:JsonProperty("matchingSelectors")
  val matchingSelectors: List<Int>,
)
