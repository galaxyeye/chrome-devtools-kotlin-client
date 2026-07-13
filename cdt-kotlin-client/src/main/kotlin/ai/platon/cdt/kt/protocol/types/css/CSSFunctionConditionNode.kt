@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * CSS function conditional block representation.
 */
data class CSSFunctionConditionNode(
  @param:JsonProperty("media")
  @param:Optional
  val media: CSSMedia? = null,
  @param:JsonProperty("containerQueries")
  @param:Optional
  val containerQueries: CSSContainerQuery? = null,
  @param:JsonProperty("supports")
  @param:Optional
  val supports: CSSSupports? = null,
  @param:JsonProperty("navigation")
  @param:Optional
  val navigation: CSSNavigation? = null,
  @param:JsonProperty("children")
  val children: List<CSSFunctionNode>,
  @param:JsonProperty("conditionText")
  val conditionText: String,
)
