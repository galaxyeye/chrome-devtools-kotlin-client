@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.collections.List

data class MatchedStylesForNode(
  @param:JsonProperty("inlineStyle")
  @param:Optional
  val inlineStyle: CSSStyle? = null,
  @param:JsonProperty("attributesStyle")
  @param:Optional
  val attributesStyle: CSSStyle? = null,
  @param:JsonProperty("matchedCSSRules")
  @param:Optional
  val matchedCSSRules: List<RuleMatch>? = null,
  @param:JsonProperty("pseudoElements")
  @param:Optional
  val pseudoElements: List<PseudoElementMatches>? = null,
  @param:JsonProperty("inherited")
  @param:Optional
  val inherited: List<InheritedStyleEntry>? = null,
  @param:JsonProperty("inheritedPseudoElements")
  @param:Optional
  val inheritedPseudoElements: List<InheritedPseudoElementMatches>? = null,
  @param:JsonProperty("cssKeyframesRules")
  @param:Optional
  val cssKeyframesRules: List<CSSKeyframesRule>? = null,
  @param:JsonProperty("cssPositionTryRules")
  @param:Optional
  val cssPositionTryRules: List<CSSPositionTryRule>? = null,
  @param:JsonProperty("activePositionFallbackIndex")
  @param:Optional
  val activePositionFallbackIndex: Int? = null,
  @param:JsonProperty("cssPropertyRules")
  @param:Optional
  val cssPropertyRules: List<CSSPropertyRule>? = null,
  @param:JsonProperty("cssPropertyRegistrations")
  @param:Optional
  val cssPropertyRegistrations: List<CSSPropertyRegistration>? = null,
  @param:JsonProperty("cssAtRules")
  @param:Optional
  val cssAtRules: List<CSSAtRule>? = null,
  @param:JsonProperty("parentLayoutNodeId")
  @param:Optional
  @param:Experimental
  val parentLayoutNodeId: Int? = null,
  @param:JsonProperty("cssFunctionRules")
  @param:Optional
  @param:Experimental
  val cssFunctionRules: List<CSSFunctionRule>? = null,
)
