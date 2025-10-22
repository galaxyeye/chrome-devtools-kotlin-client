package ai.platon.cdt.kt.protocol.types.cachestorage

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.collections.List

public data class RequestEntries(
  @field:JsonProperty("cacheDataEntries")
  public val cacheDataEntries: List<DataEntry>,
  @field:JsonProperty("returnCount")
  public val returnCount: Double,
)
