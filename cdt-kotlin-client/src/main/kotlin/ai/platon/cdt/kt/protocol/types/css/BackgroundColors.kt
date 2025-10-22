package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

public data class BackgroundColors(
  @field:JsonProperty("backgroundColors")
  @param:Optional
  public val backgroundColors: List<String>? = null,
  @field:JsonProperty("computedFontSize")
  @param:Optional
  public val computedFontSize: String? = null,
  @field:JsonProperty("computedFontWeight")
  @param:Optional
  public val computedFontWeight: String? = null,
)
