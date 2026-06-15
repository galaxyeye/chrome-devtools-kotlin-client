@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.storage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * A cache's contents have been modified.
 */
@Serializable
data class CacheStorageContentUpdated(
  @SerialName("origin")
  val origin: String,
  @SerialName("cacheName")
  val cacheName: String,
)
