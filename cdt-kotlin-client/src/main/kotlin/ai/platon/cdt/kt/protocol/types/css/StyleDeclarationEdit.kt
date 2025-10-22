package ai.platon.cdt.kt.protocol.types.css

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * A descriptor of operation to mutate style declaration text.
 */
public data class StyleDeclarationEdit(
  @field:JsonProperty("styleSheetId")
  public val styleSheetId: String,
  @field:JsonProperty("range")
  public val range: SourceRange,
  @field:JsonProperty("text")
  public val text: String,
)
