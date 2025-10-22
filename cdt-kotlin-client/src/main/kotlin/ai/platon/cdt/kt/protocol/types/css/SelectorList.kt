package ai.platon.cdt.kt.protocol.types.css

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * Selector list data.
 */
data class SelectorList(
  @field:JsonProperty("selectors")
  val selectors: List<Value>,
  @field:JsonProperty("text")
  val text: String,
)
