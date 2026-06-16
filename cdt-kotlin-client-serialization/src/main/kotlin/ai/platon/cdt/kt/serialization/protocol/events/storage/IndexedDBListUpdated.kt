@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.storage

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The origin's IndexedDB database list has been modified.
 */
@Serializable
data class IndexedDBListUpdated(
  @property:SerialName("origin")
  val origin: String,
  @property:SerialName("storageKey")
  val storageKey: String,
  @property:SerialName("bucketId")
  val bucketId: String,
)
