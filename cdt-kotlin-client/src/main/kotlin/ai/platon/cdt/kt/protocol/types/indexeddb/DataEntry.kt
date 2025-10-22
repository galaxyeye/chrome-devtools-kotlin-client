package ai.platon.cdt.kt.protocol.types.indexeddb

import ai.platon.cdt.kt.protocol.types.runtime.RemoteObject
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Data entry.
 */
public data class DataEntry(
  @field:JsonProperty("key")
  public val key: RemoteObject,
  @field:JsonProperty("primaryKey")
  public val primaryKey: RemoteObject,
  @field:JsonProperty("value")
  public val `value`: RemoteObject,
)
