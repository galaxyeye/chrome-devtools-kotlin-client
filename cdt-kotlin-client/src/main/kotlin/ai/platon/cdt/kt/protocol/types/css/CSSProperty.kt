package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * CSS property declaration data.
 */
data class CSSProperty(
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("value")
  val `value`: String,
  @field:JsonProperty("important")
  @param:Optional
  val important: Boolean? = null,
  @field:JsonProperty("implicit")
  @param:Optional
  val implicit: Boolean? = null,
  @field:JsonProperty("text")
  @param:Optional
  val text: String? = null,
  @field:JsonProperty("parsedOk")
  @param:Optional
  val parsedOk: Boolean? = null,
  @field:JsonProperty("disabled")
  @param:Optional
  val disabled: Boolean? = null,
  @field:JsonProperty("range")
  @param:Optional
  val range: SourceRange? = null,
)
