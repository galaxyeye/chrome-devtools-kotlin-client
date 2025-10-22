package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * CSS rule representation.
 */
public data class CSSRule(
  @field:JsonProperty("styleSheetId")
  @param:Optional
  public val styleSheetId: String? = null,
  @field:JsonProperty("selectorList")
  public val selectorList: SelectorList,
  @field:JsonProperty("origin")
  public val origin: StyleSheetOrigin,
  @field:JsonProperty("style")
  public val style: CSSStyle,
  @field:JsonProperty("media")
  @param:Optional
  public val media: List<CSSMedia>? = null,
)
