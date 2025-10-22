package ai.platon.cdt.kt.protocol.types.css

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.collections.List

/**
 * Media query descriptor.
 */
public data class MediaQuery(
  @field:JsonProperty("expressions")
  public val expressions: List<MediaQueryExpression>,
  @field:JsonProperty("active")
  public val active: Boolean,
)
