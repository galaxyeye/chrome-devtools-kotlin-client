@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.storage

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A cache's contents have been modified.
 */
@Serializable
data class CacheStorageContentUpdated(
  @property:SerialName("origin")
  val origin: String,
  @property:SerialName("cacheName")
  val cacheName: String,
)
