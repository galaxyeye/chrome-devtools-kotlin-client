@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.indexeddb
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.String
import kotlin.collections.List

/**
 * Database with an array of object stores.
 */
@Serializable
data class DatabaseWithObjectStores(
  @SerialName("name")
  val name: String,
  @SerialName("version")
  val version: Double,
  @SerialName("objectStores")
  val objectStores: List<ObjectStore>,
)
