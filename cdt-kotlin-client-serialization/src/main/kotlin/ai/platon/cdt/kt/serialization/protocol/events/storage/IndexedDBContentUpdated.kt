@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.storage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * The origin's IndexedDB object store has been modified.
 */
@Serializable
data class IndexedDBContentUpdated(
  @SerialName("origin")
  val origin: String,
  @SerialName("databaseName")
  val databaseName: String,
  @SerialName("objectStoreName")
  val objectStoreName: String,
)
