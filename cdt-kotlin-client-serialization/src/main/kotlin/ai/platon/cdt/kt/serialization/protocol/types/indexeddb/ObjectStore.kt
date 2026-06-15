@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.indexeddb
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

/**
 * Object store.
 */
@Serializable
data class ObjectStore(
  @SerialName("name")
  val name: String,
  @SerialName("keyPath")
  val keyPath: KeyPath,
  @SerialName("autoIncrement")
  val autoIncrement: Boolean,
  @SerialName("indexes")
  val indexes: List<ObjectStoreIndex>,
)
