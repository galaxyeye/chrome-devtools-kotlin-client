package ai.platon.cdt.kt.protocol.types.indexeddb

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

/**
 * Object store.
 */
data class ObjectStore(
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("keyPath")
  val keyPath: KeyPath,
  @field:JsonProperty("autoIncrement")
  val autoIncrement: Boolean,
  @field:JsonProperty("indexes")
  val indexes: List<ObjectStoreIndex>,
)
