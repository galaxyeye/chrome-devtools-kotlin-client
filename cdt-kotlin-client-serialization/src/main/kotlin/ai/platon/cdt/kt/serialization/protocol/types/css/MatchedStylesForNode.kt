@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MatchedStylesForNode(
  @property:SerialName("inlineStyle")
  @param:Optional
  val inlineStyle: CSSStyle? = null,
  @property:SerialName("attributesStyle")
  @param:Optional
  val attributesStyle: CSSStyle? = null,
  @property:SerialName("matchedCSSRules")
  @param:Optional
  val matchedCSSRules: List<RuleMatch>? = null,
  @property:SerialName("pseudoElements")
  @param:Optional
  val pseudoElements: List<PseudoElementMatches>? = null,
  @property:SerialName("inherited")
  @param:Optional
  val inherited: List<InheritedStyleEntry>? = null,
  @property:SerialName("cssKeyframesRules")
  @param:Optional
  val cssKeyframesRules: List<CSSKeyframesRule>? = null,
)
