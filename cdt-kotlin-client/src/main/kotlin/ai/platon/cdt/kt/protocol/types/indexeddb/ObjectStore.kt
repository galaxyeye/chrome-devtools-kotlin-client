package ai.platon.cdt.kt.protocol.types.indexeddb

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

/**
 * Object store.
 */
public data class ObjectStore(
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("keyPath")
  public val keyPath: KeyPath,
  @field:JsonProperty("autoIncrement")
  public val autoIncrement: Boolean,
  @field:JsonProperty("indexes")
  public val indexes: List<ObjectStoreIndex>,
)
