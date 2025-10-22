package ai.platon.cdt.kt.protocol.types.indexeddb

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.collections.List

data class RequestData(
  @field:JsonProperty("objectStoreDataEntries")
  val objectStoreDataEntries: List<DataEntry>,
  @field:JsonProperty("hasMore")
  val hasMore: Boolean,
)
