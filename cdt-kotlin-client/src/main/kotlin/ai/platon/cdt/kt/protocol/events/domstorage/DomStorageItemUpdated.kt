package ai.platon.cdt.kt.protocol.events.domstorage

import ai.platon.cdt.kt.protocol.types.domstorage.StorageId
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

data class DomStorageItemUpdated(
  @field:JsonProperty("storageId")
  val storageId: StorageId,
  @field:JsonProperty("key")
  val key: String,
  @field:JsonProperty("oldValue")
  val oldValue: String,
  @field:JsonProperty("newValue")
  val newValue: String,
)
