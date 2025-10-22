package ai.platon.cdt.kt.protocol.types.indexeddb

import ai.platon.cdt.kt.protocol.types.runtime.RemoteObject
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Data entry.
 */
data class DataEntry(
  @field:JsonProperty("key")
  val key: RemoteObject,
  @field:JsonProperty("primaryKey")
  val primaryKey: RemoteObject,
  @field:JsonProperty("value")
  val `value`: RemoteObject,
)
