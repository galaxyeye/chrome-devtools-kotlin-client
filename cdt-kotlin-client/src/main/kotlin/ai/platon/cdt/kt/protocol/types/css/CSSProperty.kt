package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * CSS property declaration data.
 */
public data class CSSProperty(
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("value")
  public val `value`: String,
  @field:JsonProperty("important")
  @param:Optional
  public val important: Boolean? = null,
  @field:JsonProperty("implicit")
  @param:Optional
  public val implicit: Boolean? = null,
  @field:JsonProperty("text")
  @param:Optional
  public val text: String? = null,
  @field:JsonProperty("parsedOk")
  @param:Optional
  public val parsedOk: Boolean? = null,
  @field:JsonProperty("disabled")
  @param:Optional
  public val disabled: Boolean? = null,
  @field:JsonProperty("range")
  @param:Optional
  public val range: SourceRange? = null,
)
