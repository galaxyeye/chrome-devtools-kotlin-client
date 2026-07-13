@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.indexeddb

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Object store index.
 */
@Serializable
data class ObjectStoreIndex(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("keyPath")
  val keyPath: KeyPath,
  @property:SerialName("unique")
  val unique: Boolean,
  @property:SerialName("multiEntry")
  val multiEntry: Boolean,
)
