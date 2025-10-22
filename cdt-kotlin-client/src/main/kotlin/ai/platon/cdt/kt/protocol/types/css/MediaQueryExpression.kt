package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Media query expression descriptor.
 */
public data class MediaQueryExpression(
  @field:JsonProperty("value")
  public val `value`: Double,
  @field:JsonProperty("unit")
  public val unit: String,
  @field:JsonProperty("feature")
  public val feature: String,
  @field:JsonProperty("valueRange")
  @param:Optional
  public val valueRange: SourceRange? = null,
  @field:JsonProperty("computedLength")
  @param:Optional
  public val computedLength: Double? = null,
)
