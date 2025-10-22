package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

data class MatchedStylesForNode(
  @field:JsonProperty("inlineStyle")
  @param:Optional
  val inlineStyle: CSSStyle? = null,
  @field:JsonProperty("attributesStyle")
  @param:Optional
  val attributesStyle: CSSStyle? = null,
  @field:JsonProperty("matchedCSSRules")
  @param:Optional
  val matchedCSSRules: List<RuleMatch>? = null,
  @field:JsonProperty("pseudoElements")
  @param:Optional
  val pseudoElements: List<PseudoElementMatches>? = null,
  @field:JsonProperty("inherited")
  @param:Optional
  val inherited: List<InheritedStyleEntry>? = null,
  @field:JsonProperty("cssKeyframesRules")
  @param:Optional
  val cssKeyframesRules: List<CSSKeyframesRule>? = null,
)
