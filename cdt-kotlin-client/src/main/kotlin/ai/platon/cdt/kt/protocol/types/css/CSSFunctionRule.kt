@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * CSS function at-rule representation.
 */
data class CSSFunctionRule(
  @param:JsonProperty("name")
  val name: Value,
  @param:JsonProperty("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
  @param:JsonProperty("origin")
  val origin: StyleSheetOrigin,
  @param:JsonProperty("parameters")
  val parameters: List<CSSFunctionParameter>,
  @param:JsonProperty("children")
  val children: List<CSSFunctionNode>,
  @param:JsonProperty("originTreeScopeNodeId")
  @param:Optional
  @param:Experimental
  val originTreeScopeNodeId: Int? = null,
)
