@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.storage

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Struct for a single key-value pair in an origin's shared storage.
 */
data class SharedStorageEntry(
  @param:JsonProperty("key")
  val key: String,
  @param:JsonProperty("value")
  val `value`: String,
)
