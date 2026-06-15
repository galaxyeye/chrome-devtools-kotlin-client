@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.domstorage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.domstorage.StorageId
import kotlin.String

@Serializable
data class DomStorageItemAdded(
  @SerialName("storageId")
  val storageId: StorageId,
  @SerialName("key")
  val key: String,
  @SerialName("newValue")
  val newValue: String,
)
