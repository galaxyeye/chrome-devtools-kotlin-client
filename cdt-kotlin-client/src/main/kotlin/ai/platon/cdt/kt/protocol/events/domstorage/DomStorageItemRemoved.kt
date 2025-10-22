package ai.platon.cdt.kt.protocol.events.domstorage

import ai.platon.cdt.kt.protocol.types.domstorage.StorageId
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

public data class DomStorageItemRemoved(
  @field:JsonProperty("storageId")
  public val storageId: StorageId,
  @field:JsonProperty("key")
  public val key: String,
)
