@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * CSS function conditional block representation.
 */
@Serializable
data class CSSFunctionConditionNode(
  @property:SerialName("media")
  @param:Optional
  val media: CSSMedia? = null,
  @property:SerialName("containerQueries")
  @param:Optional
  val containerQueries: CSSContainerQuery? = null,
  @property:SerialName("supports")
  @param:Optional
  val supports: CSSSupports? = null,
  @property:SerialName("navigation")
  @param:Optional
  val navigation: CSSNavigation? = null,
  @property:SerialName("children")
  val children: List<CSSFunctionNode>,
  @property:SerialName("conditionText")
  val conditionText: String,
)
