@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.storage

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The origin's IndexedDB object store has been modified.
 */
@Serializable
data class IndexedDBContentUpdated(
  @property:SerialName("origin")
  val origin: String,
  @property:SerialName("databaseName")
  val databaseName: String,
  @property:SerialName("objectStoreName")
  val objectStoreName: String,
)
