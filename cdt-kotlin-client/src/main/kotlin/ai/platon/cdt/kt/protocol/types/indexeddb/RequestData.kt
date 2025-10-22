package ai.platon.cdt.kt.protocol.types.indexeddb

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.collections.List

public data class RequestData(
  @field:JsonProperty("objectStoreDataEntries")
  public val objectStoreDataEntries: List<DataEntry>,
  @field:JsonProperty("hasMore")
  public val hasMore: Boolean,
)
