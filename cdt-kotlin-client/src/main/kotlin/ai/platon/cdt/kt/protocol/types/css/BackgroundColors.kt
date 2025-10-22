package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

data class BackgroundColors(
  @field:JsonProperty("backgroundColors")
  @param:Optional
  val backgroundColors: List<String>? = null,
  @field:JsonProperty("computedFontSize")
  @param:Optional
  val computedFontSize: String? = null,
  @field:JsonProperty("computedFontWeight")
  @param:Optional
  val computedFontWeight: String? = null,
)
