package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * CSS style representation.
 */
public data class CSSStyle(
  @field:JsonProperty("styleSheetId")
  @param:Optional
  public val styleSheetId: String? = null,
  @field:JsonProperty("cssProperties")
  public val cssProperties: List<CSSProperty>,
  @field:JsonProperty("shorthandEntries")
  public val shorthandEntries: List<ShorthandEntry>,
  @field:JsonProperty("cssText")
  @param:Optional
  public val cssText: String? = null,
  @field:JsonProperty("range")
  @param:Optional
  public val range: SourceRange? = null,
)
