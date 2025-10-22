package ai.platon.cdt.kt.protocol.types.css

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * A descriptor of operation to mutate style declaration text.
 */
data class StyleDeclarationEdit(
  @field:JsonProperty("styleSheetId")
  val styleSheetId: String,
  @field:JsonProperty("range")
  val range: SourceRange,
  @field:JsonProperty("text")
  val text: String,
)
