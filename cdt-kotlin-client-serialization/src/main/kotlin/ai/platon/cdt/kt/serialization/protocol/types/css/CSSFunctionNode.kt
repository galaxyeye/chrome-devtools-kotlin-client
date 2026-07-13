@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Section of the body of a CSS function rule.
 */
@Serializable
data class CSSFunctionNode(
  @property:SerialName("condition")
  @param:Optional
  val condition: CSSFunctionConditionNode? = null,
  @property:SerialName("style")
  @param:Optional
  val style: CSSStyle? = null,
)
