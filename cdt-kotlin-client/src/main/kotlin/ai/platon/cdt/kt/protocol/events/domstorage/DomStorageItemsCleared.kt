package ai.platon.cdt.kt.protocol.events.domstorage

import ai.platon.cdt.kt.protocol.types.domstorage.StorageId
import com.fasterxml.jackson.`annotation`.JsonProperty

public data class DomStorageItemsCleared(
  @field:JsonProperty("storageId")
  public val storageId: StorageId,
)
