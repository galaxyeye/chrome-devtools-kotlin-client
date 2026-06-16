@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.domstorage

import ai.platon.cdt.kt.serialization.protocol.types.domstorage.StorageId
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DomStorageItemRemoved(
  @property:SerialName("storageId")
  val storageId: StorageId,
  @property:SerialName("key")
  val key: String,
)
