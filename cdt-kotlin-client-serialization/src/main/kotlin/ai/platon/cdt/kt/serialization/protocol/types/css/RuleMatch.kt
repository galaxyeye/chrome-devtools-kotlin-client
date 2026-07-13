@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Match data for a CSS rule.
 */
@Serializable
data class RuleMatch(
  @property:SerialName("rule")
  val rule: CSSRule,
  @property:SerialName("matchingSelectors")
  val matchingSelectors: List<Int>,
)
