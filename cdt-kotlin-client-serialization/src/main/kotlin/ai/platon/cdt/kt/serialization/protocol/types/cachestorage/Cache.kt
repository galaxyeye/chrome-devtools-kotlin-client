@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.cachestorage

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
  @property:SerialName("cacheName")
  val cacheName: String,
)
