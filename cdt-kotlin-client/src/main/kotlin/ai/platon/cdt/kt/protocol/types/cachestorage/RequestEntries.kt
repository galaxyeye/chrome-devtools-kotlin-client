package ai.platon.cdt.kt.protocol.types.cachestorage

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.collections.List

data class RequestEntries(
  @field:JsonProperty("cacheDataEntries")
  val cacheDataEntries: List<DataEntry>,
  @field:JsonProperty("returnCount")
  val returnCount: Double,
)
