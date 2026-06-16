@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.storage

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A cache has been added/deleted.
 */
@Serializable
data class CacheStorageListUpdated(
  @property:SerialName("origin")
  val origin: String,
  @property:SerialName("storageKey")
  val storageKey: String,
  @property:SerialName("bucketId")
  val bucketId: String,
)
