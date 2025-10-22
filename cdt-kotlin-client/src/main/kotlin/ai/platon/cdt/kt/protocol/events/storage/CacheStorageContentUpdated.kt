package ai.platon.cdt.kt.protocol.events.storage

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * A cache's contents have been modified.
 */
public data class CacheStorageContentUpdated(
  @field:JsonProperty("origin")
  public val origin: String,
  @field:JsonProperty("cacheName")
  public val cacheName: String,
)
