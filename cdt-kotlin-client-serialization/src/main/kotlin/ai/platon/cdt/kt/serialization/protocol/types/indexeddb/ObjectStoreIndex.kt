@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.indexeddb
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Boolean
import kotlin.String

/**
 * Object store index.
 */
@Serializable
data class ObjectStoreIndex(
  @SerialName("name")
  val name: String,
  @SerialName("keyPath")
  val keyPath: KeyPath,
  @SerialName("unique")
  val unique: Boolean,
  @SerialName("multiEntry")
  val multiEntry: Boolean,
)
