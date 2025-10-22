package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * CSS rule representation.
 */
data class CSSRule(
  @field:JsonProperty("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
  @field:JsonProperty("selectorList")
  val selectorList: SelectorList,
  @field:JsonProperty("origin")
  val origin: StyleSheetOrigin,
  @field:JsonProperty("style")
  val style: CSSStyle,
  @field:JsonProperty("media")
  @param:Optional
  val media: List<CSSMedia>? = null,
)
