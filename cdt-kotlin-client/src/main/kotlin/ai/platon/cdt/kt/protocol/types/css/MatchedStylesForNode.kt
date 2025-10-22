package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

public data class MatchedStylesForNode(
  @field:JsonProperty("inlineStyle")
  @param:Optional
  public val inlineStyle: CSSStyle? = null,
  @field:JsonProperty("attributesStyle")
  @param:Optional
  public val attributesStyle: CSSStyle? = null,
  @field:JsonProperty("matchedCSSRules")
  @param:Optional
  public val matchedCSSRules: List<RuleMatch>? = null,
  @field:JsonProperty("pseudoElements")
  @param:Optional
  public val pseudoElements: List<PseudoElementMatches>? = null,
  @field:JsonProperty("inherited")
  @param:Optional
  public val inherited: List<InheritedStyleEntry>? = null,
  @field:JsonProperty("cssKeyframesRules")
  @param:Optional
  public val cssKeyframesRules: List<CSSKeyframesRule>? = null,
)
