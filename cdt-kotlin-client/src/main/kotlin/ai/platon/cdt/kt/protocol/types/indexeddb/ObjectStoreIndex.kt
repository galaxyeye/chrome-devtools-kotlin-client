package ai.platon.cdt.kt.protocol.types.indexeddb

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * Object store index.
 */
public data class ObjectStoreIndex(
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("keyPath")
  public val keyPath: KeyPath,
  @field:JsonProperty("unique")
  public val unique: Boolean,
  @field:JsonProperty("multiEntry")
  public val multiEntry: Boolean,
)
