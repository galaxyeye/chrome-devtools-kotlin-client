package ai.platon.cdt.kt.protocol.types.indexeddb

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * Object store index.
 */
data class ObjectStoreIndex(
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("keyPath")
  val keyPath: KeyPath,
  @field:JsonProperty("unique")
  val unique: Boolean,
  @field:JsonProperty("multiEntry")
  val multiEntry: Boolean,
)
