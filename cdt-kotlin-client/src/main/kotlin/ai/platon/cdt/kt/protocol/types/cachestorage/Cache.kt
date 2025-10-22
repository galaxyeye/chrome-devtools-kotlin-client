package ai.platon.cdt.kt.protocol.types.cachestorage

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Cache identifier.
 */
public data class Cache(
  @field:JsonProperty("cacheId")
  public val cacheId: String,
  @field:JsonProperty("securityOrigin")
  public val securityOrigin: String,
  @field:JsonProperty("cacheName")
  public val cacheName: String,
)
