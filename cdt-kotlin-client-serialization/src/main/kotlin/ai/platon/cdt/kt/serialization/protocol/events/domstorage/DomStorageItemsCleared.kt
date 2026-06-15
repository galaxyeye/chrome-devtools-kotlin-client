@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.domstorage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.domstorage.StorageId

@Serializable
data class DomStorageItemsCleared(
  @SerialName("storageId")
  val storageId: StorageId,
)
