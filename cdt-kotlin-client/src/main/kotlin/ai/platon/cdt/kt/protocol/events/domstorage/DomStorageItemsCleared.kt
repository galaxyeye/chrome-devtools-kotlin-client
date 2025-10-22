package ai.platon.cdt.kt.protocol.events.domstorage

import ai.platon.cdt.kt.protocol.types.domstorage.StorageId
import com.fasterxml.jackson.`annotation`.JsonProperty

data class DomStorageItemsCleared(
  @field:JsonProperty("storageId")
  val storageId: StorageId,
)
