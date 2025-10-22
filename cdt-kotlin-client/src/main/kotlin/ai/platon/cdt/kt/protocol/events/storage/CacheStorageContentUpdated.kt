package ai.platon.cdt.kt.protocol.events.storage

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * A cache's contents have been modified.
 */
data class CacheStorageContentUpdated(
  @field:JsonProperty("origin")
  val origin: String,
  @field:JsonProperty("cacheName")
  val cacheName: String,
)
