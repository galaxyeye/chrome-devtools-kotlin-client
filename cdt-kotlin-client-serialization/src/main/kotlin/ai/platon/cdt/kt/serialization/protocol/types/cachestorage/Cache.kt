@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.cachestorage

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.storage.StorageBucket
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Cache identifier.
 */
@Serializable
data class Cache(
  @property:SerialName("cacheId")
  val cacheId: String,
  @property:SerialName("securityOrigin")
  val securityOrigin: String,
  @property:SerialName("storageKey")
  val storageKey: String,
  @property:SerialName("storageBucket")
  @param:Optional
  val storageBucket: StorageBucket? = null,
  @property:SerialName("cacheName")
  val cacheName: String,
)
