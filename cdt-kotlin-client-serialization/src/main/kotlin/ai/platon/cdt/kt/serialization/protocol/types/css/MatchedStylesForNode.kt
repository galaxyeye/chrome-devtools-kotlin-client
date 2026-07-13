@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
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
  @property:SerialName("inheritedPseudoElements")
  @param:Optional
  val inheritedPseudoElements: List<InheritedPseudoElementMatches>? = null,
  @property:SerialName("cssKeyframesRules")
  @param:Optional
  val cssKeyframesRules: List<CSSKeyframesRule>? = null,
  @property:SerialName("cssPositionTryRules")
  @param:Optional
  val cssPositionTryRules: List<CSSPositionTryRule>? = null,
  @property:SerialName("activePositionFallbackIndex")
  @param:Optional
  val activePositionFallbackIndex: Int? = null,
  @property:SerialName("cssPropertyRules")
  @param:Optional
  val cssPropertyRules: List<CSSPropertyRule>? = null,
  @property:SerialName("cssPropertyRegistrations")
  @param:Optional
  val cssPropertyRegistrations: List<CSSPropertyRegistration>? = null,
  @property:SerialName("cssAtRules")
  @param:Optional
  val cssAtRules: List<CSSAtRule>? = null,
  @property:SerialName("parentLayoutNodeId")
  @param:Optional
  @param:Experimental
  val parentLayoutNodeId: Int? = null,
  @property:SerialName("cssFunctionRules")
  @param:Optional
  @param:Experimental
  val cssFunctionRules: List<CSSFunctionRule>? = null,
)
