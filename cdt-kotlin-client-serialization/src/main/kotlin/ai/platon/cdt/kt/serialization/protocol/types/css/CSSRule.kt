@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * CSS rule representation.
 */
@Serializable
data class CSSRule(
  @property:SerialName("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
  @property:SerialName("selectorList")
  val selectorList: SelectorList,
  @property:SerialName("nestingSelectors")
  @param:Optional
  @param:Experimental
  val nestingSelectors: List<String>? = null,
  @property:SerialName("origin")
  val origin: StyleSheetOrigin,
  @property:SerialName("style")
  val style: CSSStyle,
  @property:SerialName("originTreeScopeNodeId")
  @param:Optional
  @param:Experimental
  val originTreeScopeNodeId: Int? = null,
  @property:SerialName("media")
  @param:Optional
  val media: List<CSSMedia>? = null,
  @property:SerialName("containerQueries")
  @param:Optional
  @param:Experimental
  val containerQueries: List<CSSContainerQuery>? = null,
  @property:SerialName("supports")
  @param:Optional
  @param:Experimental
  val supports: List<CSSSupports>? = null,
  @property:SerialName("layers")
  @param:Optional
  @param:Experimental
  val layers: List<CSSLayer>? = null,
  @property:SerialName("scopes")
  @param:Optional
  @param:Experimental
  val scopes: List<CSSScope>? = null,
  @property:SerialName("ruleTypes")
  @param:Optional
  @param:Experimental
  val ruleTypes: List<CSSRuleType>? = null,
  @property:SerialName("startingStyles")
  @param:Optional
  @param:Experimental
  val startingStyles: List<CSSStartingStyle>? = null,
  @property:SerialName("navigations")
  @param:Optional
  @param:Experimental
  val navigations: List<CSSNavigation>? = null,
)
