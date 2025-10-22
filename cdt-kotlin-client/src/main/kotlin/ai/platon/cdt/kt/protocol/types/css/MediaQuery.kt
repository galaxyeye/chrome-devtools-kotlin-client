package ai.platon.cdt.kt.protocol.types.css

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.collections.List

/**
 * Media query descriptor.
 */
data class MediaQuery(
  @field:JsonProperty("expressions")
  val expressions: List<MediaQueryExpression>,
  @field:JsonProperty("active")
  val active: Boolean,
)
