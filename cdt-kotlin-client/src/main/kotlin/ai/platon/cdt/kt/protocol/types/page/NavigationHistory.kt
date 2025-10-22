package ai.platon.cdt.kt.protocol.types.page

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.collections.List

data class NavigationHistory(
  @field:JsonProperty("currentIndex")
  val currentIndex: Int,
  @field:JsonProperty("entries")
  val entries: List<NavigationEntry>,
)
