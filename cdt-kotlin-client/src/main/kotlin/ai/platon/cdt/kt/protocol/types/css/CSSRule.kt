@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * CSS rule representation.
 */
data class CSSRule(
  @param:JsonProperty("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
  @param:JsonProperty("selectorList")
  val selectorList: SelectorList,
  @param:JsonProperty("nestingSelectors")
  @param:Optional
  @param:Experimental
  val nestingSelectors: List<String>? = null,
  @param:JsonProperty("origin")
  val origin: StyleSheetOrigin,
  @param:JsonProperty("style")
  val style: CSSStyle,
  @param:JsonProperty("originTreeScopeNodeId")
  @param:Optional
  @param:Experimental
  val originTreeScopeNodeId: Int? = null,
  @param:JsonProperty("media")
  @param:Optional
  val media: List<CSSMedia>? = null,
  @param:JsonProperty("containerQueries")
  @param:Optional
  @param:Experimental
  val containerQueries: List<CSSContainerQuery>? = null,
  @param:JsonProperty("supports")
  @param:Optional
  @param:Experimental
  val supports: List<CSSSupports>? = null,
  @param:JsonProperty("layers")
  @param:Optional
  @param:Experimental
  val layers: List<CSSLayer>? = null,
  @param:JsonProperty("scopes")
  @param:Optional
  @param:Experimental
  val scopes: List<CSSScope>? = null,
  @param:JsonProperty("ruleTypes")
  @param:Optional
  @param:Experimental
  val ruleTypes: List<CSSRuleType>? = null,
  @param:JsonProperty("startingStyles")
  @param:Optional
  @param:Experimental
  val startingStyles: List<CSSStartingStyle>? = null,
  @param:JsonProperty("navigations")
  @param:Optional
  @param:Experimental
  val navigations: List<CSSNavigation>? = null,
)
