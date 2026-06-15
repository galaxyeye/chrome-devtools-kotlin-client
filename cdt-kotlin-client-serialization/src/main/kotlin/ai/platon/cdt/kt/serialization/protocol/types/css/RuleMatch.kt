@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int
import kotlin.collections.List

/**
 * Match data for a CSS rule.
 */
@Serializable
data class RuleMatch(
  @SerialName("rule")
  val rule: CSSRule,
  @SerialName("matchingSelectors")
  val matchingSelectors: List<Int>,
)
