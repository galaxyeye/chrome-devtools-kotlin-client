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
 * CSS function at-rule representation.
 */
@Serializable
data class CSSFunctionRule(
  @property:SerialName("name")
  val name: Value,
  @property:SerialName("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
  @property:SerialName("origin")
  val origin: StyleSheetOrigin,
  @property:SerialName("parameters")
  val parameters: List<CSSFunctionParameter>,
  @property:SerialName("children")
  val children: List<CSSFunctionNode>,
  @property:SerialName("originTreeScopeNodeId")
  @param:Optional
  @param:Experimental
  val originTreeScopeNodeId: Int? = null,
)
