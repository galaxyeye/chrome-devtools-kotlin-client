@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.indexeddb

import kotlin.Double
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Database with an array of object stores.
 */
@Serializable
data class DatabaseWithObjectStores(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("version")
  val version: Double,
  @property:SerialName("objectStores")
  val objectStores: List<ObjectStore>,
)
