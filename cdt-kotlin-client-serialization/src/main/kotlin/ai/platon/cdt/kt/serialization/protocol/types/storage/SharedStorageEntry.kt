@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.storage

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Struct for a single key-value pair in an origin's shared storage.
 */
@Serializable
data class SharedStorageEntry(
  @property:SerialName("key")
  val key: String,
  @property:SerialName("value")
  val `value`: String,
)
