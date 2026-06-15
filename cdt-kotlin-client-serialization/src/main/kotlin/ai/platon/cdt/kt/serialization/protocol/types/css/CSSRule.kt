@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List

/**
 * CSS rule representation.
 */
@Serializable
data class CSSRule(
  @SerialName("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
  @SerialName("selectorList")
  val selectorList: SelectorList,
  @SerialName("origin")
  val origin: StyleSheetOrigin,
  @SerialName("style")
  val style: CSSStyle,
  @SerialName("media")
  @param:Optional
  val media: List<CSSMedia>? = null,
)
