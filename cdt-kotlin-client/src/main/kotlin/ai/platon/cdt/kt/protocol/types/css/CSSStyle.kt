package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * CSS style representation.
 */
data class CSSStyle(
  @field:JsonProperty("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
  @field:JsonProperty("cssProperties")
  val cssProperties: List<CSSProperty>,
  @field:JsonProperty("shorthandEntries")
  val shorthandEntries: List<ShorthandEntry>,
  @field:JsonProperty("cssText")
  @param:Optional
  val cssText: String? = null,
  @field:JsonProperty("range")
  @param:Optional
  val range: SourceRange? = null,
)
