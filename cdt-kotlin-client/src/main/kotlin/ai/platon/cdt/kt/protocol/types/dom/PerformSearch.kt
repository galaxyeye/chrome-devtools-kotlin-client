package ai.platon.cdt.kt.protocol.types.dom

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

data class PerformSearch(
  @field:JsonProperty("searchId")
  val searchId: String,
  @field:JsonProperty("resultCount")
  val resultCount: Int,
)
