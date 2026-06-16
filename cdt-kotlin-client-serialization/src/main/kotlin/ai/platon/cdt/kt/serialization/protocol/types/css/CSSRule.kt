@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
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
  @property:SerialName("origin")
  val origin: StyleSheetOrigin,
  @property:SerialName("style")
  val style: CSSStyle,
  @property:SerialName("media")
  @param:Optional
  val media: List<CSSMedia>? = null,
)
