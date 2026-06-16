@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.indexeddb

import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Object store.
 */
@Serializable
data class ObjectStore(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("keyPath")
  val keyPath: KeyPath,
  @property:SerialName("autoIncrement")
  val autoIncrement: Boolean,
  @property:SerialName("indexes")
  val indexes: List<ObjectStoreIndex>,
)
