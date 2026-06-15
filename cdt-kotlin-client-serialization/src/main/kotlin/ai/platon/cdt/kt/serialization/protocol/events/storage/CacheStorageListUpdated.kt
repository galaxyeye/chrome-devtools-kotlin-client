@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.storage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * A cache has been added/deleted.
 */
@Serializable
data class CacheStorageListUpdated(
  @SerialName("origin")
  val origin: String,
)
