@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.storage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * The origin's IndexedDB database list has been modified.
 */
@Serializable
data class IndexedDBListUpdated(
  @SerialName("origin")
  val origin: String,
)
