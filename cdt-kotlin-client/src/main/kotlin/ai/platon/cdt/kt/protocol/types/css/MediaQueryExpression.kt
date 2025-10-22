package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Media query expression descriptor.
 */
data class MediaQueryExpression(
  @field:JsonProperty("value")
  val `value`: Double,
  @field:JsonProperty("unit")
  val unit: String,
  @field:JsonProperty("feature")
  val feature: String,
  @field:JsonProperty("valueRange")
  @param:Optional
  val valueRange: SourceRange? = null,
  @field:JsonProperty("computedLength")
  @param:Optional
  val computedLength: Double? = null,
)
