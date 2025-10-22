package ai.platon.cdt.kt.protocol.types.cachestorage

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Cache identifier.
 */
data class Cache(
  @field:JsonProperty("cacheId")
  val cacheId: String,
  @field:JsonProperty("securityOrigin")
  val securityOrigin: String,
  @field:JsonProperty("cacheName")
  val cacheName: String,
)
