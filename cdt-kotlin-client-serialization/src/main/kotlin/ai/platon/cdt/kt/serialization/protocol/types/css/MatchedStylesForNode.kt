@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.collections.List

@Serializable
data class MatchedStylesForNode(
  @SerialName("inlineStyle")
  @param:Optional
  val inlineStyle: CSSStyle? = null,
  @SerialName("attributesStyle")
  @param:Optional
  val attributesStyle: CSSStyle? = null,
  @SerialName("matchedCSSRules")
  @param:Optional
  val matchedCSSRules: List<RuleMatch>? = null,
  @SerialName("pseudoElements")
  @param:Optional
  val pseudoElements: List<PseudoElementMatches>? = null,
  @SerialName("inherited")
  @param:Optional
  val inherited: List<InheritedStyleEntry>? = null,
  @SerialName("cssKeyframesRules")
  @param:Optional
  val cssKeyframesRules: List<CSSKeyframesRule>? = null,
)
