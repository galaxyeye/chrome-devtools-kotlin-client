package ai.platon.cdt.kt.protocol.types.page

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.collections.List

public data class NavigationHistory(
  @field:JsonProperty("currentIndex")
  public val currentIndex: Int,
  @field:JsonProperty("entries")
  public val entries: List<NavigationEntry>,
)
