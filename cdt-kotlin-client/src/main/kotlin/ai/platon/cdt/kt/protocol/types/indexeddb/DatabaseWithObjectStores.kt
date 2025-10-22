package ai.platon.cdt.kt.protocol.types.indexeddb

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String
import kotlin.collections.List

/**
 * Database with an array of object stores.
 */
public data class DatabaseWithObjectStores(
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("version")
  public val version: Double,
  @field:JsonProperty("objectStores")
  public val objectStores: List<ObjectStore>,
)
