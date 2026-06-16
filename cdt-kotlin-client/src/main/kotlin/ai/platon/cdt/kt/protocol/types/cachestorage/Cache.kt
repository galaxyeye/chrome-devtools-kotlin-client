@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.cachestorage

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.storage.StorageBucket
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Cache identifier.
 */
data class Cache(
  @param:JsonProperty("cacheId")
  val cacheId: String,
  @param:JsonProperty("securityOrigin")
  val securityOrigin: String,
  @param:JsonProperty("storageKey")
  val storageKey: String,
  @param:JsonProperty("storageBucket")
  @param:Optional
  val storageBucket: StorageBucket? = null,
  @param:JsonProperty("cacheName")
  val cacheName: String,
)
