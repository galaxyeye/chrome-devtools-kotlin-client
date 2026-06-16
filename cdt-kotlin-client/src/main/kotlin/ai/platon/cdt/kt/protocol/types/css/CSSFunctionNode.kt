@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Section of the body of a CSS function rule.
 */
data class CSSFunctionNode(
  @param:JsonProperty("condition")
  @param:Optional
  val condition: CSSFunctionConditionNode? = null,
  @param:JsonProperty("style")
  @param:Optional
  val style: CSSStyle? = null,
)
