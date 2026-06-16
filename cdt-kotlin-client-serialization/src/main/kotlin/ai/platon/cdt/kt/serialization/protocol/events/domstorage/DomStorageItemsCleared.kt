@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.domstorage

import ai.platon.cdt.kt.serialization.protocol.types.domstorage.StorageId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DomStorageItemsCleared(
  @property:SerialName("storageId")
  val storageId: StorageId,
)
